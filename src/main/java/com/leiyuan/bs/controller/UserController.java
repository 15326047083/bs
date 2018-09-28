package com.leiyuan.bs.controller;

import com.leiyuan.bs.entity.User;
import com.leiyuan.bs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

// 用户控制层
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService; // 自动注入UserService

    /**
     * 跳转
     *
     * @return 注册页面
     */
    @RequestMapping("/toNewUser")
    public String toNewUser() {
        return "user/new";
    }

    /**
     * 用户注册
     *
     * @param user 新增用户表单
     * @return 成功或者失败
     */
    @ResponseBody
    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public String newUser(User user) {
        return userService.newUser(user);
    }

    /**
     * 跳转
     *
     * @param model  向页面传递用户原始信息
     * @param userId 用户ID
     * @return 用户修改页面
     */
    @RequestMapping("/toUpdateUser/{userId}")
    public String toUpdateUser(Model model, @PathVariable("userId") Integer userId) {
        model.addAttribute("user", userService.getById(userId));
        return "user/update";
    }

    /**
     * 用户更新
     *
     * @param user 用户详细信息
     * @return 修改结果成功与否
     */
    @ResponseBody
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public String updateUser(User user) {
        return userService.updateUser(user);
    }

    /**
     * 删除用户
     *
     * @param userId 用户主键
     * @return 成功与否
     */
    @ResponseBody
    @RequestMapping("/deleteUser/{userId}")
    public String deleteUser(@PathVariable("userId") Integer userId) {
        return userService.deleteUser(userId);
    }

    /**
     * 跳转
     *
     * @param model 向页面传递用户列表
     * @return 用户管理页面（获取所有用户列表）
     */
    @RequestMapping("/toUserList")
    public String toUserList(Model model) {
        model.addAttribute("userList", userService.queryAll());
        return "user/list";
    }
}
