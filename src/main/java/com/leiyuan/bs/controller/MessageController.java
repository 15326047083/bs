package com.leiyuan.bs.controller;

import com.leiyuan.bs.entity.Message;
import com.leiyuan.bs.service.MessageService;
import com.leiyuan.bs.vo.MessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//留言控制层
@Controller
@RequestMapping("/message")
public class MessageController{
    @Autowired
    private MessageService messageService;

    /**
     * 新建评论  新建回复
     * @param message
     * @return
     */
    @RequestMapping(value = "/addMessage",method = RequestMethod.POST)
    public String addMessage(Message message){

        messageService.addMessage(message);
        return "success";
    }

    /**
     * 获取评论列表
     * @return
     */
    @RequestMapping(value = "toList")
    @ResponseBody
    public List<MessageVo> toList(){

        return messageService.getList();
    }
}
