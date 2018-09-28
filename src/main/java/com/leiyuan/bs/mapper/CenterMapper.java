package com.leiyuan.bs.mapper;

import com.leiyuan.bs.entity.Center;

public interface CenterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Center record);

    int insertSelective(Center record);

    Center selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Center record);

    int updateByPrimaryKey(Center record);
}