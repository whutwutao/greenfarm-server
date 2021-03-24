package com.wu.greenfarm.controller;

import com.wu.greenfarm.pojo.User;
import com.wu.greenfarm.pojo.UserMessage;
import com.wu.greenfarm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public UserMessage register(@RequestBody User user) {
        if (user != null) {
            if (userService.register(user)) {
                return new UserMessage(true,null);
            } else {
                return new UserMessage(false,"该手机号已注册");
            }
        } else {
            return new UserMessage(false,"客户端数据传输异常");
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public UserMessage login(@RequestBody User user) {
        if (user != null) {
            if (userService.login(user)) {
                return new UserMessage(true,null);
            } else {
                return new UserMessage(false,"手机号或密码错误");
            }
        } else {
            return new UserMessage(false,"客户端数据传输异常");
        }
    }
}