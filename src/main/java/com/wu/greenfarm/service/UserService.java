package com.wu.greenfarm.service;

import com.wu.greenfarm.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    /**
     * 注册用户
     * @param user
     * @return
     */
    boolean register(User user);

    /**
     * 用户登录
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 获取所有用户
     * @return
     */
    List<User> getAllUser();

    int changePassword(User user);
}
