package com.leiyuan.bs.service.impl;

import com.leiyuan.bs.entity.Apply;
import com.leiyuan.bs.entity.User;
import com.leiyuan.bs.mapper.ApplyMapper;
import com.leiyuan.bs.mapper.RecruitmentMapper;
import com.leiyuan.bs.service.ApplyService;
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

    @Override
    public String apply(Integer reId, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("userSession");
        if (user == null)
            return "error";
        else if (reId == null)
            return "error";
        else if (recruitmentMapper.selectByPrimaryKey(reId) == null)
            return "error";
        Apply apply = new Apply();
        apply.setState(0);
        //获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        apply.setApplyTime(sdf.format(new Date()));
        apply.setReId(reId);
        apply.setUserId(user.getId());
        applyMapper.insert(apply);
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
