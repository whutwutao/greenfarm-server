package com.wu.greenfarm.mapper;

import com.wu.greenfarm.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    /**
     * 将一个用户的信息添加至数据库的t_user表中
     * @param user
     * @return int
     */
    int addUser(User user);

    /**
     * 根据手机号查询用户
     * @param telephone
     * @return User
     */
    User queryUserByTelephone(@Param("telephone") String telephone);

}
