package com.dream.mentor.dao.user;

import com.dream.mentor.bean.user.MentorUser;
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
    MentorUser getUserByName(@Param("userName") String userName);

    /**
     * 根据用户Id查询用户
     *
     * @param userId
     * @return
     */
    @Select("select id as userId, user_name as userName,mobile,password,salt,company_name as companyName,telephone,user_status as userStatus from api_users where id = #{userId} ")
    MentorUser getUserByUserId(@Param("userId") long userId);

    @Insert("insert into api_users (user_name,password,salt,mobile,company_name,address,telephone) " +
            "values" +
            "(#{mentorUser.userName},#{mentorUser.password},#{mentorUser.salt},#{mentorUser.mobile},#{mentorUser.companyName},#{mentorUser.address},#{mentorUser.telephone})")
    @Options(useGeneratedKeys = true, keyProperty = "mentorUser.userId")
    long saveUser(@Param("mentorUser") MentorUser mentorUser);

    @Update("update api_users set user_status = #{mentorUser.userStatus} ,password = #{password} where id = #{userId}")
    int updateUser(@Param("mentorUser")MentorUser mentorUser);
}