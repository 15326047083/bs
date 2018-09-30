package com.leiyuan.bs.controller;

import com.leiyuan.bs.entity.Message;
import com.leiyuan.bs.service.MessageService;
import com.leiyuan.bs.vo.MessageVo;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//留言控制层
@Controller
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    /**
     * 新建评论  新建回复
     *
     * @param message 留言或回复信息
     * @return 成功与否
     */
    @ResponseBody
    @RequestMapping(value = "/addMessage", method = RequestMethod.POST)
    public String addMessage(Message message, HttpServletRequest request) {
        return messageService.addMessage(message, request);
    }

    /**
     * 获取评论列表
     *
     * @return 列表
     */
    @RequestMapping(value = "/toList")
    public String toList(Model model) {
        model.addAttribute("list", messageService.getList());
        return "message/list";
    }
}
