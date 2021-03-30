package com.wu.greenfarm.service;

import com.wu.greenfarm.mapper.UserMapper;
import com.wu.greenfarm.pojo.User;
import com.wu.greenfarm.utils.VerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public VerificationCode getVerificationCode() {
        return new VerificationCode(160,40,5,150);
    }

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

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public int changePassword(User user) {
        return userMapper.changePassword(user.getId(),user.getPassword());
    }

    @Override
    public int changeUsername(User user) {
        return userMapper.changeUsername(user.getId(), user.getUsername());
    }

    @Override
    public int changeTelephone(User user) {
        User user1 = userMapper.queryUserByTelephone(user.getTelephone());
        if (user1 == null) {
            return userMapper.changeTelephone(user.getId(),user.getTelephone());
        } else {
            return -1;
        }
    }
}
