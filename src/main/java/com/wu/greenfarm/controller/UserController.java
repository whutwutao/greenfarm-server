package com.wu.greenfarm.controller;

import com.wu.greenfarm.pojo.User;
import com.wu.greenfarm.message.UserMessage;
import com.wu.greenfarm.service.UserService;
import com.wu.greenfarm.utils.VerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/getVerificationCode", method = RequestMethod.GET)
    public Map<String,String> getVerificationCode() {
        Map<String,String> hashMap = new HashMap<>();
        VerificationCode verificationCode = userService.getVerificationCode();
        verificationCode.createCode();
        hashMap.put("encodedImage",verificationCode.encode());
        hashMap.put("code",verificationCode.getCode());
        return hashMap;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public UserMessage register(@RequestBody User user) {
        if (user != null) {
            if (userService.register(user)) {
                return new UserMessage(true,null,null);
            } else {
                return new UserMessage(false,"该手机号已注册",null);
            }
        } else {
            return new UserMessage(false,"客户端数据传输异常",null);
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public UserMessage login(@RequestBody User user) {
        if (user != null) {
            User user1 = userService.login(user);
            if (user1 != null) {
                return new UserMessage(true,null,user1);
            } else {
                return new UserMessage(false,"手机号或密码错误",null);
            }
        } else {
            return new UserMessage(false,"客户端数据传输异常",null);
        }
    }

    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    public List<User> getAllUser() {
        return userService.getAllUser();
    }


    @RequestMapping(value = "/getUserLimit", method = RequestMethod.POST)
    public List<User> getUserLimit(@RequestBody HashMap<String, Integer> map) {
        if (map != null) {
            int start = map.get("start");
            int len = map.get("len");
            return userService.getUserLimit(start, len);
        } else {
            return new ArrayList<User>();
        }
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public UserMessage changePassword(@RequestBody User user) {
        if (user != null) {
            if (userService.changePassword(user) > 0) {
                return new UserMessage(true,null,null);
            } else {
                return new UserMessage(false,"密码修改失败",null);
            }
        } else {
            return new UserMessage(false,"客户端数据传输异常",null);
        }
    }

    @RequestMapping(value = "/changeUsername", method = RequestMethod.POST)
    public UserMessage changeUsername(@RequestBody User user) {
        if (user != null) {
            if (userService.changeUsername(user) > 0) {
                return new UserMessage(true,null,null);
            } else {
                return new UserMessage(false,"用户名修改失败",null);
            }
        } else {
            return new UserMessage(false,"客户端数据传输异常",null);
        }
    }

    @RequestMapping(value = "/changeTelephone", method = RequestMethod.POST)
    public UserMessage changeTelephone(@RequestBody User user) {
        if (user != null) {
            System.out.println(user);
            if (userService.changeTelephone(user) > 0) {
                return new UserMessage(true,null,null);
            } else {
                return new UserMessage(false,"用户名修改失败",null);
            }
        } else {
            return new UserMessage(false,"客户端数据传输异常",null);
        }
    }

    @RequestMapping(value = "/getProductFarmer")
    public User getProductFarmer (@RequestBody HashMap<String,String> request) {
        if (request != null) {
            String strId = request.get("farmerId");
            int id = Integer.parseInt(strId);
            User user = userService.getUserById(id);
            if (user != null) {
                user.setPassword("");
            }
            return user;
        } else {
            return null;
        }
    }
}
