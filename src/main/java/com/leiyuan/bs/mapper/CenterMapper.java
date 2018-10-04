package com.leiyuan.bs.mapper;

import com.leiyuan.bs.entity.Center;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CenterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Center record);

    int insertSelective(Center record);

    Center selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Center record);

    int updateByPrimaryKey(Center record);

    List<Center> queryAll(@Param("type") Integer type);

    List<Center> getAllList();
}