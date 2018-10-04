package com.leiyuan.bs.mapper;

import com.leiyuan.bs.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int countPhone(String phone);

    List<User> queryAll();

    User login(User user);

    List<User> getFiveUser();
}