package com.leiyuan.bs.service;

import com.leiyuan.bs.vo.MyApplyVo;
import com.leiyuan.bs.vo.ReApplyVo;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import java.util.List;

public interface ApplyService {
    String apply(Integer reId, HttpServletRequest request);

    List<MyApplyVo> queryMyApplyList(HttpServletRequest request);

    List<ReApplyVo> getReApplyList(Integer reId);

    String deleteApply(Integer applyId, HttpServletRequest request);
}
