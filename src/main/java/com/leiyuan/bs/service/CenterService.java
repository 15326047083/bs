package com.leiyuan.bs.service;

import com.leiyuan.bs.entity.Center;

import java.util.List;

public interface CenterService {
    List<Center> queryAll();

    String newCenter(Center center);

    Center getById(Integer centerId);

    String updateCenter(Center center);

    String deleteCenter(Integer centerId);
}
