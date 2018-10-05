package com.leiyuan.bs.service.impl;

import com.leiyuan.bs.entity.User;
import com.leiyuan.bs.mapper.UserMapper;
import com.leiyuan.bs.service.UserService;
import com.leiyuan.bs.util.EmailUtil;
import com.leiyuan.bs.util.MD5;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public String newUser(User user) {
        String password = user.getPassword();
        if (user.getPassword().length() < 6)
            return "error";
        else
            user.setPassword(MD5.md5(user.getPassword()));
        if (verifyUserInfo(user)) return "error";
        else if (userMapper.countPhone(user.getPhone()) != 0)
            return "error";
        userMapper.insert(user);
        String info = "登录名/手机号:" + user.getPhone() + "  密码：" + password;
        EmailUtil.sample(user.getEmail(), info);
        return "success";
    }

    @Override
    public List<User> queryAll(HttpServletRequest request) {
        User userSession = (User) request.getSession().getAttribute("userSession");
        if (userSession == null)
            return null;
        else if (userSession.getState() != -1)
            return null;
        return userMapper.queryAll();
    }

    @Override
    public User getById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public String updateUser(User user) {
        String password = user.getPassword();
        if (user.getPassword().length() < 6)
            return "error";
        else
            user.setPassword(MD5.md5(user.getPassword()));
        if (verifyUserInfo(user)) return "error";
        userMapper.updateByPrimaryKeySelective(user);
        String info = "登录名/手机号:" + user.getPhone() + "  密码：" + password;
        EmailUtil.sample(user.getEmail(), info);
        return "success";
    }

    /**
     * 验证用户信息是否符合要求
     *
     * @param user 用户信息
     * @return true、false
     */
    private boolean verifyUserInfo(User user) {
        String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(user.getEmail());
        boolean isMatched = matcher.matches();
        if ("".equals(user.getName()))
            return true;
        else if ("".equals(user.getPassword()) || user.getPassword().length() < 6)
            return true;
        else if ("".equals(user.getPhone()) || user.getPhone().length() != 11)
            return true;
        else if (user.getAge() == null || user.getAge() < 0 || user.getAge() > 50)
            return true;
        else if (!isMatched)
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
        user.setPassword(MD5.md5(user.getPassword()));
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
        return "redirect:/user/toLogin";
    }
}
