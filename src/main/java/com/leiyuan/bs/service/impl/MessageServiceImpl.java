package com.leiyuan.bs.service.impl;

import com.leiyuan.bs.entity.Message;
import com.leiyuan.bs.entity.User;
import com.leiyuan.bs.mapper.MessageMapper;
import com.leiyuan.bs.service.MessageService;
import com.leiyuan.bs.vo.MessageVo;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
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

    @Override
    public String addMessage(Message message, HttpServletRequest request) {
        //Session 获取 userId
        User user = (User) request.getSession().getAttribute("userSession");
        if (user == null)
            return "error";
        if (message.getInfo().length() > 1000 || message.getInfo().length() < 10)
            return "error";
        //获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        message.setTime(sdf.format(new Date()));
        message.setUserId(user.getId());
        messageMapper.insert(message);
        return "success";
    }

    @Override
    public List<MessageVo> getList() {
        List<MessageVo> list = messageMapper.getMessageList();
        // System.out.println(list);
        for (MessageVo v : list) {
            v.setReplyVoList(messageMapper.getReplyList(v.getId()));
        }
        return list;
    }
}
