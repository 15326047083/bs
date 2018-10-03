package com.leiyuan.bs.service;

import com.leiyuan.bs.entity.Recruitment;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import java.util.List;

public interface RecruitmentService {
    String newRecruitment(Recruitment recruitment, HttpServletRequest request);

    Recruitment getById(Integer recruitmentId);

    String update(Recruitment recruitment, HttpServletRequest request);

    String updateRecruitmentState(Integer applyId, HttpServletRequest request, Integer state);

    String deleteRecruitment(Integer recruitmentId, HttpServletRequest request);

    List<Recruitment> queryAll();
}
