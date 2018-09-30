package com.leiyuan.bs;

import com.leiyuan.bs.entity.Center;
import com.leiyuan.bs.entity.User;
import com.leiyuan.bs.service.CenterService;
import com.leiyuan.bs.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class leiyuanTest {
    @Autowired
    private UserService userService;
    @Autowired
    private CenterService centerService;

    @Test
    public void testNewUser() {
        User user = new User();
        user.setAge(10);
        user.setEmail("15326047083@163.com");
        user.setName("雷园");
        user.setPassword("123456");
        user.setPhone("15326047082");
        user.setSex("男");
        user.setState(0);
        int a[] = {1, 2, 3, 4, 5};
        int n = 10;
        System.out.println(n /= 5);
        System.out.println(userService.newUser(user));
    }

    @Test
    public void testQueryAllUser() {
        System.out.println(userService.queryAll());
    }

    @Test
    public void testUserLogin() {
        User user = new User();
        user.setPhone("15326047083");
        user.setPassword("123456");
        System.out.println(userService.login(user, null));
    }

    @Test
    public void testQueryAllCenter() {
        System.out.println(centerService.queryAll(1));
    }

    @Test
    public void testNewCenter() {
        Center center = new Center();
        center.setInfo("上课不准吸烟！");
        center.setTitle("第二条");
        center.setState(0);
        System.out.println(centerService.newCenter(center));
    }

    @Test
    public void testDeleteCenter() {
        centerService.deleteCenter(2, null);
    }
}
