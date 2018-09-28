package com.leiyuan.bs.service;

import com.leiyuan.bs.entity.Recruitment;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;

public interface RecruitmentService {
    String newRecruitment(Recruitment recruitment);

    Recruitment getById(Integer recruitmentId);

    String update(Recruitment recruitment);

    String updateRecruitmentState(Integer recruitmentId, HttpServletRequest request);

    String deleteRecruitment(Integer recruitmentId);
}
