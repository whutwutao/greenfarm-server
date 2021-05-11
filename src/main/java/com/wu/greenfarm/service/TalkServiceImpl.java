package com.wu.greenfarm.service;

import com.wu.greenfarm.mapper.TalkMapper;
import com.wu.greenfarm.pojo.Talk;
import com.wu.greenfarm.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TalkServiceImpl implements TalkService{

    @Autowired
    TalkMapper talkMapper;

    @Override
    public int addTalk(Talk talk) {
        int sender = talk.getSender();
        int receiver = talk.getReceiver();
        List<Talk> list = talkMapper.getTalkBySenderAndReceiver(sender,receiver);
        if (list == null || list.isEmpty()) {
            return talkMapper.addTalk(talk);
        } else {
            return 0;
        }
    }

    @Override
    public List<Talk> getTalkBySender(int sender) {
        return talkMapper.getTalkBySender(sender);
    }

    @Override
    public List<User> getFriendsBySender(int sender) {
        return talkMapper.getFriendBySender(sender);
    }
}
