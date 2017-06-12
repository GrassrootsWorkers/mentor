package com.dream.mentor.interfaces.user;

import com.dream.mentor.bean.user.User;

/**
 * Created by Administrator on 2017/5/5.
 */
public interface IUserService {
    /**
     * 注册用户
     * @param user
     * @return
     * @throws Exception
     */
    long saveUser(User user) throws Exception;

    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     */
    User getUserByName(String userName);

    /**
     * 根据用户Id查询用户
     * @param userId
     * @return
     */
    User getUserById(long userId);

    /**
     * 用户登陆
     * @param user
     * @param password
     * @param platform
     * @return
     */
    String userLogin(User user, String password, String platform);
}
