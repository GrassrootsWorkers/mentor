package com.dream.mentor.interfaces.user;

import com.dream.mentor.bean.user.MentorExtraUser;
import com.dream.mentor.bean.user.MentorUser;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by Administrator on 2017/5/5.
 */
public interface IUserService {
    /**
     * 注册用户
     * @param mentorUser
     * @return
     * @throws Exception
     */
    int saveUser(MentorUser mentorUser) throws Exception;



    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     */
    MentorUser getUserByName(String userName);

    /**
     * 根据用户Id查询用户
     * @param userId
     * @return
     */
    MentorUser getUserById(long userId);

    /**
     *
     * @param openId
     * @return
     */
    MentorUser getUserByOpenId(String openId);

    /**
     * 更新user
     * @param user
     * @return
     */
    int updateMentorUser(MentorUser user) throws InvalidKeySpecException, NoSuchAlgorithmException;

    /**
     * 用户登陆
     * @param mentorUser
     * @param password
     * @param platform
     * @return
     */
    String userLogin(MentorUser mentorUser, String password, String platform);

    /**
     * 保存用户附件信息
     * @param extraUser
     * @return
     */
    int saveExtraUser(MentorExtraUser extraUser);

    /**
     * 获取用户扩展信息
     * @param userId
     * @return
     */
    MentorExtraUser getExtraUserByUserId(int userId);
}
