package com.wu.greenfarm.mapper;

import com.wu.greenfarm.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User queryUserById(@Param("id") int id);

    /**
     * 获取所有用户
     * @return
     */
    List<User> getAllUser();

    /**
     *
     * @param start 起始位置
     * @param len 记录个数
     * @return
     */
    List<User> getUserLimit(@Param("start") int start, @Param("len") int len);

    /**
     * 修改密码
     * @param password
     * @return
     */
    int changePassword(@Param("id") int id, @Param("password") String password);

    /**
     * 修改用户名
     * @param id
     * @param username
     * @return
     */
    int changeUsername(@Param("id") int id, @Param("username") String username);

    /**
     * 修改手机号
     * @param id
     * @param telephone
     * @return
     */
    int changeTelephone(@Param("id") int id, @Param("telephone") String telephone);


    String getTelephone(@Param("id") int id);
}
