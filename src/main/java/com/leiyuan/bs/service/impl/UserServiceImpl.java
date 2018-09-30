package com.leiyuan.bs.service.impl;

import com.leiyuan.bs.entity.User;
import com.leiyuan.bs.mapper.UserMapper;
import com.leiyuan.bs.service.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public String newUser(User user) {
        if (verifyUserInfo(user)) return "error";
        userMapper.insert(user);
        return "success";
    }

    @Override
    public List<User> queryAll() {
        return userMapper.queryAll();
    }

    @Override
    public User getById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public String updateUser(User user) {
        if (verifyUserInfo(user)) return "error";
        userMapper.updateByPrimaryKeySelective(user);
        return "success";
    }

    /**
     * 验证用户信息是否符合要求
     *
     * @param user 用户信息
     * @return true、false
     */
    private boolean verifyUserInfo(User user) {
        if ("".equals(user.getName()))
            return true;
        else if ("".equals(user.getPassword()) || user.getPassword().length() < 6)
            return true;
        else if ("".equals(user.getPhone()) || user.getPhone().length() != 11)
            return true;
        else if (user.getAge() == null || user.getAge() < 0 || user.getAge() > 50)
            return true;
        else if (userMapper.countPhone(user.getPhone()) != 0)
            return true;
        return false;
    }

    @Override
    public String deleteUser(Integer userId, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("userSession");
        if (user == null)
            return "error";
        if (user.getState() != -1)
            return "error";
        else if (userMapper.selectByPrimaryKey(userId) == null)
            return "error";
        else if (user.getId().equals(userId))
            return "error";
        userMapper.deleteByPrimaryKey(userId);
        return "success";
    }

    @Override
    public String login(User user, HttpServletRequest request) {
        if (user.getPhone().length() != 11)
            return "error";
        else if (user.getPassword().length() < 6)
            return "error";
        else if (userMapper.countPhone(user.getPhone()) < 1)
            return "error";
        else if (userMapper.login(user) == null)
            return "error";
        request.getSession().setAttribute("userSession", userMapper.login(user));
        return "success";
    }

    @Override
    public String loginOut(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User userSession = (User) session.getAttribute("userSession");
        if (userSession != null)
            session.removeAttribute("userSession");
        return "redirect:user/toLogin";
    }
}
