package com.leiyuan.bs.service;

import com.leiyuan.bs.entity.Message;
import com.leiyuan.bs.vo.MessageVo;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import java.util.List;

public interface MessageService {
    /**
     * 新建评论
     *
     * @param message
     */
    String addMessage(Message message, HttpServletRequest request);

    /**
     * 查看评论列表
     *
     * @return
     */
    List<MessageVo> getList();
}
