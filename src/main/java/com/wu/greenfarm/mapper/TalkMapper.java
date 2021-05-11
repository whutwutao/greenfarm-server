package com.wu.greenfarm.mapper;

import com.wu.greenfarm.pojo.Talk;
import com.wu.greenfarm.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TalkMapper {
    //添加Talk
    int addTalk(Talk talk);
    //按id查询Talk
    Talk getTalkById(@Param("id") int id);
    //按from查询Talk
    List<Talk> getTalkBySender(@Param("sender") int sender);
    //按from和to查询Talk
    List<Talk> getTalkBySenderAndReceiver(@Param("sender") int sender, @Param("receiver") int receiver);

    List<User> getFriendBySender(@Param("sender") int sender);

}
