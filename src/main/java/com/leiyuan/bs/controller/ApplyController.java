package com.leiyuan.bs.controller;

import com.leiyuan.bs.service.ApplyService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 岗位申请
@Controller
@RequestMapping("/apply")
public class ApplyController {
    @Autowired
    private ApplyService applyService; // 自动注入applyService

    /**
     * 岗位申请
     *
     * @param reId    岗位ID
     * @param request 获取当前登陆用户信息
     *                判断当前登陆用户是否为应聘者
     *                查看当前用户是否申请过该岗位
     * @return 成功与否
     */
    @ResponseBody
    @RequestMapping("/apply/{reId}")
    public String apply(@PathVariable("reId") Integer reId, HttpServletRequest request) {
        return applyService.apply(reId, request);
    }

    /**
     * 取消本人的申请信息（删除申请）
     *
     * @param applyId 申请ID
     * @param request 获取当前登陆的用户信息
     *                根据申请ID获取申请信息
     *                通过与当前用户的信息比对，正确则返回成功，否则返回失败
     * @return 成功与否
     */
    @ResponseBody
    @RequestMapping("/deleteApply/{applyId}")
    public String deleteApply(@PathVariable("applyId") Integer applyId, HttpServletRequest request) {
        return applyService.deleteApply(applyId, request);
    }

    /**
     * 查看我的申请
     *
     * @param model 向页面传递申请列表
     *              通过ApplyVo向页面传递岗位信息、申请信息
     * @return 我的申请
     */
    @RequestMapping("/getMyApplyList")
    public String getMyApplyList(Model model, HttpServletRequest request) {
        model.addAttribute("myApplyList", applyService.queryMyApplyList(request));
        return "apply/myList";
    }

    /**
     * 根据岗位ID获取当前岗位申请列表
     *
     * @param reId  岗位ID
     * @param model 向页面传递申请列表
     * @return 跳转至岗位申请列表
     */
    @RequestMapping("/getReApplyList/{reId}")
    public String getReApplyList(@PathVariable("reId") Integer reId, Model model) {
        model.addAttribute("reApplyList", applyService.getReApplyList(reId));
        return "apply/reList";
    }
}
