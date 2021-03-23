package com.wu.greenfarm.service;

import com.wu.greenfarm.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    boolean registerUser(User user);
}
