package com.leiyuan.bs.controller;

import com.leiyuan.bs.util.APIUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class APIController {
    /**
     * 跳转
     *
     * @return 新闻页面
     */
    @RequestMapping("/toNews")
    public String toNews() {
        return "api/news";
    }

    /**
     * 随机获取当前热门的十条新闻
     *
     * @return 返回json数据
     */
    @RequestMapping("/getTenNews")
    @ResponseBody
    public String getTenNews() {
        return APIUtil.news();
    }
}
