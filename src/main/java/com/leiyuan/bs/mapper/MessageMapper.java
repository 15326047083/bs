package com.leiyuan.bs.mapper;

import com.leiyuan.bs.entity.Message;
import com.leiyuan.bs.vo.MessageVo;
import com.leiyuan.bs.vo.ReplyVo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);

    List<MessageVo> getMessageList();

    List<ReplyVo> getReplyList(Integer id);

}