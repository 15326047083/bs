package com.leiyuan.bs.service;

import com.leiyuan.bs.entity.Message;
import com.leiyuan.bs.vo.MessageVo;

import java.util.List;

public interface MessageService {
    /**
     * 新建评论
     * @param message
     */
    void addMessage(Message message);

    /**
     * 查看评论列表
     * @return
     */
    List<MessageVo> getList();
}
