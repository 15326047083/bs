package com.leiyuan.bs.service;

import com.leiyuan.bs.entity.User;

import java.util.List;

public interface UserService {
    String newUser(User user);

    List<User> queryAll();

    User getById(Integer userId);

    String updateUser(User user);

    String deleteUser(Integer userId);
}
