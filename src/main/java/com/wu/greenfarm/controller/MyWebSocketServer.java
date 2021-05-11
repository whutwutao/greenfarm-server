package com.wu.greenfarm.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wu.greenfarm.pojo.Message;
import com.wu.greenfarm.pojo.User;
import com.wu.greenfarm.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;



@ServerEndpoint("/test")
@Component
public class MyWebSocketServer {


    public static UserService userService;

    private static Map<String, Session> clients = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session) {
        Map<String, List<String>> requestParameterMap = session.getRequestParameterMap();
        System.out.println(requestParameterMap);
        String userId = requestParameterMap.get("userId").get(0);
        clients.put(userId, session);
    }

    @OnClose
    public void onClose(Session session) {
        Map<String, List<String>> requestParameterMap = session.getRequestParameterMap();
        String userId = requestParameterMap.get("userId").get(0);
        System.out.println("有用户断开了, userId为："+userId);
        clients.remove(userId);
    }

    @OnMessage
    public void onMessage(Session session, String dataStr) {
        System.out.println(dataStr);
        Map<String, List<String>> requestParameterMap = session.getRequestParameterMap();

        String userId = requestParameterMap.get("userId").get(0);
        try {

            Message message = new Gson().fromJson(dataStr,Message.class);
            String content = message.getContent();
            int from = message.getFrom();
            int to = message.getTo();
            User sender = userService.getUserById(from);
            System.out.println(sender.toString());
            //用map存发送的消息内容以及发送者的信息
            HashMap<String,String> map = new HashMap<>();
            map.put("content",content);//消息内容
            map.put("sender",new Gson().toJson(sender));
            String dataToReceiver = new Gson().toJson(map);

            System.out.println(map.get("content"));
            System.out.println(map.get("sender"));
            System.out.println(dataToReceiver);
            HashMap<String, String> tmpMap = new HashMap<>();
            tmpMap = new Gson().fromJson(dataToReceiver,new TypeToken<HashMap<String,String>>(){}.getType());
            System.out.println(tmpMap.get("sender"));
            System.out.println(tmpMap.get("content"));
            //转发给接收者
            clients.get(String.valueOf(to)).getBasicRemote().sendText(dataToReceiver);

//            session.getBasicRemote().sendText(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnError
    public void onError(Throwable throwable) {
        System.out.println(throwable.getMessage());
        System.out.println("出了错");
    }

}
