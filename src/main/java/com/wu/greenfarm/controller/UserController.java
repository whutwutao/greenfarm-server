package com.wu.greenfarm.controller;

import com.wu.greenfarm.pojo.User;
import com.wu.greenfarm.pojo.UserRegisterMessage;
import com.wu.greenfarm.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public UserRegisterMessage registerUser(@RequestBody User user) {
        if (user != null) {
            if (userService.registerUser(user)) {
                return new UserRegisterMessage(true,null);
            } else {
                return new UserRegisterMessage(false,"该手机号已注册");
            }
        } else {
            return new UserRegisterMessage(false,"客户端数据传输异常");
        }
    }

}
