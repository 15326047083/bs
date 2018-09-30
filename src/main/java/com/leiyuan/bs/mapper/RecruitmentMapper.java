package com.leiyuan.bs.mapper;

import com.leiyuan.bs.entity.Recruitment;
import org.springframework.stereotype.Component;

@Component
public interface RecruitmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Recruitment record);

    int insertSelective(Recruitment record);

    Recruitment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Recruitment record);

    int updateByPrimaryKey(Recruitment record);
}