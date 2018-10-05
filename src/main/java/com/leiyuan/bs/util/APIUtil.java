package com.leiyuan.bs.util;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class APIUtil {
    // 天气API
    public static String weather(String name) {
        String weather = "";
        String host = "http://weather-ali.juheapi.com";
        String path = "/weather/index";
        String method = "GET";
        String appcode = "d7b2e7a36744403793b1951d3507c588";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("cityname", name);
        querys.put("dtype", "json");
        querys.put("format", "2");
        try {
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            //获取response的body
            weather = EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return weather;
    }

    // 历史上的今天
    public static String history() {
        String history = "";
        String host = "https://ali-todayhistory.showapi.com";
        String path = "/today-of-history";
        String method = "GET";
        String appcode = "d7b2e7a36744403793b1951d3507c588";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("date", "");
        try {
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            //获取response的body
            history = EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return history;
    }

    // 新闻焦点
    public static String news() {
        Random random = new Random();
        int a = random.nextInt(10);
        int b = random.nextInt(10);
        String news = "";
        String host = "http://ali-news.showapi.com";
        String path = "/newsList";
        String method = "GET";
        String appcode = "d7b2e7a36744403793b1951d3507c588";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("channelId", "5572a108b3cdc86cf39001cd");
        querys.put("channelName", "");
        querys.put("maxResult", "10");
        querys.put("needAllList", "0");
        querys.put("needContent", "0");
        querys.put("needHtml", "1");
        querys.put("page", String.valueOf(a * b));
        querys.put("title", "");
        try {
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            //获取response的body
            news = EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return news;
    }
}
