package com.dream.mentor.dao.user;

import com.dream.mentor.bean.user.MentorUser;
import com.dream.mentor.common.StringUtil;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by Administrator on 2017/5/4.
 */
public class UserSqlProvider {
    public String updateMentorUser(final MentorUser user){
        return new SQL(){{
            UPDATE("mentor_users");
            if(StringUtil.areNotEmpty(user.getPassword())){
                SET("password=#{password}");
            }
            if(StringUtil.areNotEmpty(user.getMobile())){
                SET("mobile=#{mobile}");
            }
            if(StringUtil.areNotEmpty(user.getUserName())){
                SET("user_name=#{userName}");
            }
            if(StringUtil.areNotEmpty(user.getOpenId())){
                WHERE("open_id=#{openId}");
            }
            WHERE("id = #{id}");
        }}.toString();
    }

}