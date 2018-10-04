package com.leiyuan.bs.service;

import com.leiyuan.bs.entity.Center;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import java.util.List;

public interface CenterService {
    List<Center> queryAll(Integer type);

    String newCenter(Center center, HttpServletRequest request);

    Center getById(Integer centerId);

    String updateCenter(Center center, HttpServletRequest request);

    String deleteCenter(Integer centerId, HttpServletRequest request);
}
