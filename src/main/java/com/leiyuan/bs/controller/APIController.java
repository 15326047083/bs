package com.leiyuan.bs.controller;

import com.leiyuan.bs.util.APIUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    /**
     * 获取历史上的今天
     *
     * @return json
     */
    @RequestMapping("/getHistoryToday")
    @ResponseBody
    public String getHistoryToday() {
        return APIUtil.history();
    }

    /**
     * 跳转
     *
     * @return 天气页面
     */
    @RequestMapping("/toWeather")
    public String toWeather() {
        return "api/weather";
    }

    /**
     * 获取城市天气，默认北京
     *
     * @param name 城市名称
     * @return 天气json
     */
    @RequestMapping("/getWeather")
    @ResponseBody
    public String getWeather(@RequestParam(value = "name", defaultValue = "北京") String name) {
        return APIUtil.weather(name);
    }

}
