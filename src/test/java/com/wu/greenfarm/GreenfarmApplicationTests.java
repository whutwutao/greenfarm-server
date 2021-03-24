package com.wu.greenfarm;

import com.wu.greenfarm.mapper.UserMapper;
import com.wu.greenfarm.pojo.User;
import com.wu.greenfarm.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GreenfarmApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    UserMapper userMapper;

    @Test
    void addUserTest() {
        User user = new User("小红","123","10010");
        userMapper.addUser(user);
    }


    @Autowired
    UserServiceImpl userService;
    @Test
    void registerUserTest() {
        User user = new User("小黑","123","12580");
        if (userService == null) {
            System.out.println("null");
        } else {
            userService.register(user);
        }
    }

    @Test
    void loginTest() {
        User user = new User(null,"123","10086");
        if (userService.login(user)) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
    }
}
