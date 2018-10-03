package com.leiyuan.bs.mapper;

import com.leiyuan.bs.entity.Recruitment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RecruitmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Recruitment record);

    int insertSelective(Recruitment record);

    Recruitment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Recruitment record);

    int updateByPrimaryKey(Recruitment record);

    List<Recruitment> queryAll();

    Integer countByUserIdAndReId(@Param("reId") Integer reId, @Param("id") Integer id);
}