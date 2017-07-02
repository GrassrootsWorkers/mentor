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
     * @param openId
     * @return
     */
    @Select("select id,user_name,mobile,open_id,password,register_date,user_type,salt,user_status,login_date,create_date,update_date" +
            " from mentor_users  where open_id = #{openId}")
    MentorUser getUserByOpenId(@Param("openId") String openId);

    @Select("select id,user_name,mobile,open_id,password,register_date,user_type,salt,user_status,login_date,create_date,update_date" +
            " from mentor_users  where user_name = #{userName}")
    MentorUser getUserByUserName(@Param("userName") String userName);

    /**
     * 根据用户Id查询用户
     *
     * @param userId
     * @return
     */
    @Select("select id,user_name,mobile,open_id,password,register_date,user_type,salt,user_status,login_date,create_date,update_date" +
            " from mentor_users  where id = #{userId}")
    MentorUser getUserByUserId(@Param("userId") long userId);

    @Insert("insert into mentor_users (user_name,mobile,open_id,password,register_date,user_type,salt,user_status,login_date,create_date,update_date) " +
            "values" +
            "(#{user.userName},#{user.mobile},#{user.openId},#{user.password},#{user.registerDate},#{user.userType},#{user.salt},#{user.userStatus},#{user.loginDate},#{user.createDate},#{user.updateDate})")
    @Options(useGeneratedKeys = true, keyProperty = "user.id")
    long saveUser(@Param("user") MentorUser mentorUser);

    @UpdateProvider(type = UserSqlProvider.class, method = "updateMentorUser")
    int updateUser(MentorUser mentorUser);
}