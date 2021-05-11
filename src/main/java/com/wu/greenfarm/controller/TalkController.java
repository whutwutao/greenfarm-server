package com.wu.greenfarm.controller;

import com.wu.greenfarm.pojo.Talk;
import com.wu.greenfarm.pojo.User;
import com.wu.greenfarm.service.TalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class TalkController {

    @Autowired
    TalkService talkService;

    @RequestMapping(value = "/addTalk")
    public HashMap<String,String> addTalk(@RequestBody Talk talk) {
        HashMap<String,String> result = new HashMap<>();
        if (talk == null) {
            result.put("result","talk is null");
        } else {
            talkService.addTalk(talk);
            result.put("result","success");
        }
        return result;
    }

    @RequestMapping(value = "/getFriends")
    public List<User> getFriends(@RequestBody HashMap<String,Integer> map) {
        if (map == null) {
            return new ArrayList<>();
        } else {
            int sender = map.get("sender");
            return talkService.getFriendsBySender(sender);
        }
    }
}
