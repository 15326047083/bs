package com.leiyuan.bs.service.impl;

import com.leiyuan.bs.entity.Apply;
import com.leiyuan.bs.entity.Recruitment;
import com.leiyuan.bs.entity.User;
import com.leiyuan.bs.mapper.ApplyMapper;
import com.leiyuan.bs.mapper.RecruitmentMapper;
import com.leiyuan.bs.mapper.UserMapper;
import com.leiyuan.bs.service.ApplyService;
import com.leiyuan.bs.util.EmailUtil;
import com.leiyuan.bs.vo.MyApplyVo;
import com.leiyuan.bs.vo.ReApplyVo;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ApplyServiceImpl implements ApplyService {
    @Autowired
    private ApplyMapper applyMapper;
    @Autowired
    private RecruitmentMapper recruitmentMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public String apply(Integer reId, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("userSession");
        if (user == null)
            return "error";
        else if (reId == null)
            return "error";
        else if (recruitmentMapper.selectByPrimaryKey(reId) == null)
            return "error";
        else if (recruitmentMapper.countByUserIdAndReId(reId, user.getId()) > 0)
            return "error";
        Apply apply = new Apply();
        apply.setState(0);
        //获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        apply.setApplyTime(sdf.format(new Date()));
        apply.setReId(reId);
        apply.setUserId(user.getId());
        applyMapper.insert(apply);
        Recruitment recruitment = recruitmentMapper.selectByPrimaryKey(reId);
        // TODO 更改登陆连接地址
        String info = "用户:" + user.getName() + "，申请了你发布的岗位，请及时<a href='http://localhost:8080/user/toLogin'>点此登陆</a>查看！";
        User reUser = userMapper.selectByPrimaryKey(recruitment.getUserId());
        // 发送邮件给岗位发布者
        EmailUtil.sample(reUser.getEmail(), info);
        return "success";
    }

    @Override
    public List<MyApplyVo> queryMyApplyList(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("userSession");
        if (user == null)
            return null;
        return applyMapper.queryMyApplyList(user.getId());
    }

    @Override
    public List<ReApplyVo> getReApplyList(Integer reId) {
        if (recruitmentMapper.selectByPrimaryKey(reId) == null)
            return null;
        return applyMapper.getReApplyList(reId);
    }

    @Override
    public String deleteApply(Integer applyId, HttpServletRequest request) {
        Apply apply = applyMapper.selectByPrimaryKey(applyId);
        User user = (User) request.getSession().getAttribute("userSession");
        if (apply == null)
            return "error";
        else if (user == null)
            return "error";
        else if (!user.getId().equals(apply.getUserId()))
            return "error";
        applyMapper.deleteByPrimaryKey(applyId);
        return "success";
    }
}
