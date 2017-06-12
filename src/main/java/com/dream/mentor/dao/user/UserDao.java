package com.dream.mentor.dao.user;

import com.dream.mentor.bean.user.User;
import org.apache.ibatis.annotations.*;

/**
 * Created by Administrator on 2017/5/4.
 */
@Mapper
public interface UserDao {
    /**
     * 根据用户名查询用户
     *
     * @param userName
     * @return
     */
    @Select("select id as userId, user_name as userName,mobile,password,salt,company_name as companyName,telephone,user_status as userStatus from api_users where user_name = #{userName} ")
    User getUserByName(@Param("userName") String userName);

    /**
     * 根据用户Id查询用户
     *
     * @param userId
     * @return
     */
    @Select("select id as userId, user_name as userName,mobile,password,salt,company_name as companyName,telephone,user_status as userStatus from api_users where id = #{userId} ")
    User getUserByUserId(@Param("userId") long userId);

    @Insert("insert into api_users (user_name,password,salt,mobile,company_name,address,telephone) " +
            "values" +
            "(#{user.userName},#{user.password},#{user.salt},#{user.mobile},#{user.companyName},#{user.address},#{user.telephone})")
    @Options(useGeneratedKeys = true, keyProperty = "user.userId")
    long saveUser(@Param("user") User user);

    @Update("update api_users set user_status = #{user.userStatus} ,password = #{password} where id = #{userId}")
    int updateUser(@Param("user")User user);
}