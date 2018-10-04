package com.leiyuan.bs.controller;

import com.leiyuan.bs.entity.Center;
import com.leiyuan.bs.service.CenterService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

// 中心简介，法律法规等
@Controller
@RequestMapping("/center")
public class CenterController {
    @Autowired
    private CenterService centerService; // 自动注入centerService

    /**
     * 跳转
     *
     * @return 新增页面
     */
    @RequestMapping("/toNewCenter")
    public String toNewCenter() {
        return "center/new";
    }

    /**
     * 跳转
     *
     * @param type  分类（0为中心简介、1为法律法规）
     * @param model 向页面传递列表
     * @return 中心简介，法律法规列表
     */
    @RequestMapping("/toCenterList/{type}")
    public String toCenterList(@PathVariable("type") Integer type, Model model) {
        model.addAttribute("centerList", centerService.queryAll(type));
        return "center/list";
    }


    /**
     * 新增
     *
     * @param center 新增法律法规
     * @return 成功或者失败
     */
    @ResponseBody
    @RequestMapping(value = "/newCenter", method = RequestMethod.POST)
    public String newCenter(Center center, HttpServletRequest request) {
        return centerService.newCenter(center, request);
    }

    /**
     * 跳转
     *
     * @param model    向页面传递法律法规原始信息
     * @param centerId 法律法规主键
     * @return 修改页面
     */
    @RequestMapping("/toUpdateCenter/{centerId}")
    public String toUpdateCenter(Model model, @PathVariable("centerId") Integer centerId) {
        model.addAttribute("center", centerService.getById(centerId));
        return "center/update";
    }

    /**
     * 更新
     *
     * @param center 详细信息
     * @return 修改结果成功与否
     */
    @ResponseBody
    @RequestMapping(value = "/updateCenter", method = RequestMethod.POST)
    public String updateCenter(Center center, HttpServletRequest request) {
        return centerService.updateCenter(center, request);
    }

    /**
     * 删除
     *
     * @param centerId 主键
     * @return 成功与否
     */
    @ResponseBody
    @RequestMapping("/deleteCenter/{centerId}")
    public String deleteCenter(@PathVariable("centerId") Integer centerId, HttpServletRequest request) {
        return centerService.deleteCenter(centerId, request);
    }

}
