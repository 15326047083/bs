package com.leiyuan.bs.controller;

import com.leiyuan.bs.entity.Recruitment;
import com.leiyuan.bs.service.RecruitmentService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

// 应聘信息
@Controller
@RequestMapping("/recruit")
public class RecruitmentController {
    @Autowired
    private RecruitmentService recruitmentService; // 自动注入RecruitmentService

    /**
     * 跳转
     *
     * @return 新增页面
     */
    @RequestMapping("/toNewRecruitment")
    public String toNewRecruitment() {
        return "recruitment/new";
    }

    /**
     * 新增
     *
     * @param recruitment 应聘信息
     * @return 成功否与否
     */
    @ResponseBody
    @RequestMapping(value = "newRecruitment", method = RequestMethod.POST)
    public String newRecruitment(Recruitment recruitment) {
        return recruitmentService.newRecruitment(recruitment);
    }

    /**
     * 跳转
     *
     * @param recruitmentId 应聘信息的ID
     * @param model         向页面传递原始数据
     * @return 更新页面
     */
    @RequestMapping("/toUpdateRecruitment/{recruitmentId}")
    public String toUpdateRecruitment(@PathVariable("recruitmentId") Integer recruitmentId, Model model) {
        model.addAttribute("recruitment", recruitmentService.getById(recruitmentId));
        return "recruitment/update";
    }

    /**
     * 修改应聘信息
     *
     * @param recruitment 应聘信息
     * @return 成功与否
     */
    @ResponseBody
    @RequestMapping(value = "updateRecruitment", method = RequestMethod.POST)
    public String updateRecruitment(Recruitment recruitment) {
        return recruitmentService.update(recruitment);
    }

    /**
     * 更新应聘信息的状态
     * 如果发布者确认了应聘信息
     * 则更在应聘信息的状态为1（应聘成功 ）
     *
     * @param recruitmentId 应聘信息ID
     * @param request       传递用户session
     *                      判断当前登陆用户是否为应聘信息发布者，匹配则成功，否则失败
     * @return 成功与否
     */
    @ResponseBody
    @RequestMapping("/updateRecruitmentState/{recruitmentId}")
    public String updateRecruitmentState(@PathVariable("recruitmentId") Integer recruitmentId, HttpServletRequest
            request) {
        return recruitmentService.updateRecruitmentState(recruitmentId, request);
    }

    /**
     * 应聘信息删除
     *
     * @param recruitmentId 应聘信息ID
     * @return 成功与否
     */
    @ResponseBody
    @RequestMapping("/deleteRecruitment/{recruitmentId}")
    public String deleteRecruitment(@PathVariable("recruitmentId") Integer recruitmentId) {
        return recruitmentService.deleteRecruitment(recruitmentId);
    }
}
