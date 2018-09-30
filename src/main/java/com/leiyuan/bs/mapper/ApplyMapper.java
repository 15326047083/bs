package com.leiyuan.bs.mapper;

import com.leiyuan.bs.entity.Apply;
import com.leiyuan.bs.vo.MyApplyVo;
import com.leiyuan.bs.vo.ReApplyVo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ApplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Apply record);

    int insertSelective(Apply record);

    Apply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Apply record);

    int updateByPrimaryKey(Apply record);

    List<MyApplyVo> queryMyApplyList(Integer userId);

    List<ReApplyVo> getReApplyList(Integer reId);
}