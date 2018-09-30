package com.leiyuan.bs.service.impl;

import com.leiyuan.bs.entity.Message;
import com.leiyuan.bs.mapper.MessageMapper;
import com.leiyuan.bs.service.MessageService;
import com.leiyuan.bs.vo.MessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;

    /**
     * 新建评论
     *
     * @param message
     */
    @Override
    public void addMessage(Message message) {
        //Session 获取 userId

        //获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        message.setTime(sdf.format(new Date()));

        messageMapper.insert(message);
    }

    /**
     * 查看评论列表
     *
     * @return
     */
    @Override
    public List<MessageVo> getList() {
        List<MessageVo> list = messageMapper.getMessageList();
        // System.out.println(list);
        for (MessageVo v : list) {
            v.setReplyVoList(messageMapper.getReplyList(v.getId()));
            System.out.println(v.getReplyVoList());
        }
        return list;
    }
}
