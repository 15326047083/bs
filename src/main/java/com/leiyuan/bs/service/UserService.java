package com.leiyuan.bs.service;

import com.leiyuan.bs.entity.User;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import java.util.List;

public interface UserService {
    String newUser(User user);

    List<User> queryAll(HttpServletRequest request);

    User getById(Integer userId);

    String updateUser(User user);

    String deleteUser(Integer userId, HttpServletRequest request);

    String login(User user, HttpServletRequest request);

    String loginOut(HttpServletRequest request);
}
