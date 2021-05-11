package com.wu.greenfarm.service;

import com.wu.greenfarm.pojo.Talk;
import com.wu.greenfarm.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TalkService {
    //添加Talk
    int addTalk(Talk talk);
    //按Sender查询Talk
    List<Talk> getTalkBySender(int sender);

    List<User> getFriendsBySender(int sender);
}
