package com.wu.greenfarm.controller;

import com.wu.greenfarm.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@RequestBody User user) {
        if (user != null) {
            System.out.println(user);
            return "success";
        } else {
            return "fail";
        }
    }

}
