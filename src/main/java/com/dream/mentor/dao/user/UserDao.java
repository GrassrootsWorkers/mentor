package com.dream.mentor.dao.user;

import com.dream.mentor.bean.user.MentorExtraUser;
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
    int saveUser(@Param("user") MentorUser mentorUser);

    @UpdateProvider(type = UserSqlProvider.class, method = "updateMentorUser")
    int updateUser(MentorUser mentorUser);
    //添加用户扩展信息
    @Insert("insert into mentor_user_extras (user_id,name,province,city,area,graduate_date,school,major,resume_url,interests,create_date,update_date) " +
                   "values" +
                   "(#{extraUser.userId},#{extraUser.name},#{extraUser.province},#{extraUser.city},#{extraUser.area},#{extraUser.graduateDate},#{extraUser.school},#{extraUser.major},#{extraUser.resumeUrl},#{extraUser.interests},now(),now())")
    @Options(useGeneratedKeys = true, keyProperty = "extraUser.id")
    int saveExtraUserInfo(@Param("extraUser") MentorExtraUser extraUser);

    @Select("select name,province,city,area,graduate_date graduateDate,school,major,resume_url resumeUrl,interests from mentor_user_extras where user_id = #{userId} ")
    MentorExtraUser getExtraUserByUserId(@Param("userId") int userId);
}