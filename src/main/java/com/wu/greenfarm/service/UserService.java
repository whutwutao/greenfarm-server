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

    /**
     * 修改密码
     * @param user
     * @return
     */
    int changePassword(User user);

    /**
     * 修改用户名
     * @param user
     * @return
     */
    int changeUsername(User user);

    /**
     * 修改手机号
     * @param user
     * @return
     */
    int changeTelephone(User user);
}
