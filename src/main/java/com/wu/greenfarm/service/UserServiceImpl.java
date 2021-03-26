package com.wu.greenfarm.service;

import com.wu.greenfarm.mapper.UserMapper;
import com.wu.greenfarm.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean register(User user) {
        if (userMapper.queryUserByTelephone(user.getTelephone()) == null) {
            userMapper.addUser(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User login(User user) {
        User user1 = userMapper.queryUserByTelephone(user.getTelephone());
        if (user1 == null) {
            return null;
        }
        if (user1.getPassword().equals(user.getPassword())) {
            return user1;
        } else {
            return null;
        }
    }
}
