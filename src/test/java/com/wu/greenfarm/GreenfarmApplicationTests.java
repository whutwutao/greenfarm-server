package com.wu.greenfarm;

import com.wu.greenfarm.mapper.UserMapper;
import com.wu.greenfarm.pojo.User;
import com.wu.greenfarm.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
        System.out.println(userService.login(user));
    }

    @Test
    void getAllUserTest() {
        List<User> userList = userService.getAllUser();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    void changePassword() {
        User user = new User();
        user.setId(13);
        user.setPassword("4321");
        System.out.println(userService.changePassword(user));

    }
}
