package com.leiyuan.bs.service.impl;

import com.leiyuan.bs.mapper.ApplyMapper;
import com.leiyuan.bs.service.ApplyService;
import com.leiyuan.bs.vo.MyApplyVo;
import com.leiyuan.bs.vo.ReApplyVo;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ApplyServiceImpl implements ApplyService {
    @Autowired
    private ApplyMapper applyMapper;
    @Override
    public String apply(Integer reId, HttpServletRequest request) {
        return null;
    }

    /**
     * 获取个人申请列表
     * @return
     */
    @Override
    public List<MyApplyVo> queryMyApplyList(HttpServletRequest request) {
        //session 内获取Userid
    //    request.getSession("");
        int userId=1;
        return applyMapper.queryMyApplyList(userId);
    }

    /**
     * 查看岗位下的申请列表
     * @param reId  岗位id
     * @return
     */
    @Override
    public List<ReApplyVo> getReApplyList(Integer reId) {

        return applyMapper.getReApplyList(reId);
    }

    @Override
    public String deleteApply(Integer applyId, HttpServletRequest request) {
        return null;
    }
}
