package com.leiyuan.bs.controller;

import com.leiyuan.bs.entity.User;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FilterController {
    /**
     * 简单拦截
     *
     * @param request 获取登陆信息
     * @return 重定向至登陆页面或主页
     */
    @RequestMapping("/")
    public String filter(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("userSession");
        if (user != null)
            return "redirect:/user/toIndex";
        else return "redirect:/user/toLogin";
    }

}
