package com.leiyuan.bs.service.impl;

import com.leiyuan.bs.entity.Apply;
import com.leiyuan.bs.entity.Recruitment;
import com.leiyuan.bs.entity.User;
import com.leiyuan.bs.mapper.ApplyMapper;
import com.leiyuan.bs.mapper.RecruitmentMapper;
import com.leiyuan.bs.mapper.UserMapper;
import com.leiyuan.bs.service.RecruitmentService;
import com.leiyuan.bs.util.EmailUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitmentServiceImpl implements RecruitmentService {
    @Autowired
    private RecruitmentMapper recruitmentMapper;
    @Autowired
    private ApplyMapper applyMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public String newRecruitment(Recruitment recruitment, HttpServletRequest request) {
        User userSession = (User) request.getSession().getAttribute("userSession");
        if (userSession == null)
            return "error";
        if (userSession.getState() != 1)
            return "error";
        else if (verifyRE(recruitment)) return "error";
        recruitment.setUserId(userSession.getId());
        recruitment.setState(0);
        recruitmentMapper.insert(recruitment);
        List<User> users = userMapper.getFiveUser();
        for (User u : users) {
            String info = "有适合你的岗位发布了，快上去看看吧！<a href=''>点此查看</a>";
            EmailUtil.sample(u.getEmail(), info);
        }
        return "success";
    }

    @Override
    public Recruitment getById(Integer recruitmentId) {
        return recruitmentMapper.selectByPrimaryKey(recruitmentId);
    }

    @Override
    public String update(Recruitment recruitment, HttpServletRequest request) {
        User userSession = (User) request.getSession().getAttribute("userSession");
        if (userSession == null)
            return "error";
        if (!userSession.getId().equals(recruitment.getUserId()) || userSession.getState() != 1)
            return "error";
        else if (verifyRE(recruitment)) return "error";
        recruitmentMapper.updateByPrimaryKeySelective(recruitment);
        return "success";
    }

    /**
     * 判断应聘信息是否符合规定
     *
     * @param recruitment 应聘信息
     * @return true、false
     */
    private boolean verifyRE(Recruitment recruitment) {
        if (recruitment.getTitle().length() > 30 || recruitment.getTitle().length() < 3)
            return true;
        else if (recruitment.getMoney() < 0)
            return true;
        else if (recruitment.getInfo().length() < 20 || recruitment.getInfo().length() > 2000)
            return true;
        else if (recruitment.getPlaceState() != 0 && recruitment.getPlaceState() != 1)
            return true;
        return false;
    }

    @Override
    public String updateRecruitmentState(Integer applyId, HttpServletRequest request, Integer state) {
        User userSession = (User) request.getSession().getAttribute("userSession");
        if (userSession == null)
            return "error";
        Apply apply = applyMapper.selectByPrimaryKey(applyId);
        if (apply == null)
            return "error";
        Recruitment recruitment = recruitmentMapper.selectByPrimaryKey(apply.getReId());
        if (recruitment == null)
            return "error";
        if (!recruitment.getUserId().equals(userSession.getId()))
            return "error";
        if (state == 1) {
            recruitment.setState(1);
            apply.setState(1);
        } else if (state == 2) {
            apply.setState(2);
        }
        recruitmentMapper.updateByPrimaryKeySelective(recruitment);
        applyMapper.updateByPrimaryKey(apply);
        return "success";
    }

    @Override
    public String deleteRecruitment(Integer recruitmentId, HttpServletRequest request) {
        User userSession = (User) request.getSession().getAttribute("userSession");
        if (userSession == null)
            return "error";
        Recruitment recruitment = recruitmentMapper.selectByPrimaryKey(recruitmentId);
        if (recruitment == null)
            return "error";
        if (!userSession.getId().equals(recruitment.getUserId()) || userSession.getState() != 1)
            return "error";
        recruitmentMapper.deleteByPrimaryKey(recruitmentId);
        return "success";
    }

    @Override
    public List<Recruitment> queryAll() {
        return recruitmentMapper.queryAll();
    }
}
