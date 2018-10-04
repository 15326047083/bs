package com.leiyuan.bs;

import com.leiyuan.bs.entity.Center;
import com.leiyuan.bs.entity.User;
import com.leiyuan.bs.mapper.RecruitmentMapper;
import com.leiyuan.bs.service.CenterService;
import com.leiyuan.bs.service.UserService;
import com.leiyuan.bs.util.APIUtil;
import com.leiyuan.bs.util.EmailUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;

@RunWith(SpringRunner.class)
@SpringBootTest
public class leiyuanTest {
    @Autowired
    private UserService userService;
    @Autowired
    private CenterService centerService;
    @Autowired
    private RecruitmentMapper recruitmentMapper;

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
        System.out.println(centerService.newCenter(center, null));
    }

    @Test
    public void testDeleteCenter() {
        centerService.deleteCenter(2, null);
    }

    @Test
    public void testCount() {
        System.out.println(recruitmentMapper.countByUserIdAndReId(1, 1));
    }

    @Test
    public void testEmail() {
        EmailUtil.sample("15326047083@163.com", "我是雷园<a href='https://www.baidu.com/'>点此登陆查看</a>");
    }

    @Test
    public void testMD5() {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update("123456".getBytes());
            byte s[] = messageDigest.digest();
            String result = "";
            for (int i = 0; i < s.length; i++) {
                result += Integer.toHexString((0x000000ff & s[i]) | 0xffffff00).substring(6);
            }
            System.out.println(result);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCenterList() {
        System.out.println(centerService.queryAll(5));
    }

    @Test
    public void testWeather() {
        APIUtil.weather("包头");
    }

    @Test
    public void testHistory() {
        System.out.println(APIUtil.history());
    }

    @Test
    public void testNews() {
        System.out.println(APIUtil.news());
    }
}
