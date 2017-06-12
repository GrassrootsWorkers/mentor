package com.dream.mentor.service.user;

import com.dream.mentor.bean.user.User;
import com.dream.mentor.common.StringUtil;
import com.dream.mentor.dao.user.UserDao;
import com.dream.mentor.interfaces.user.IUserService;
import com.dream.mentor.common.AesCiperTokenUtil;
import com.dream.mentor.common.PBKDFUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/4.
 */
@Service
public class UserServiceImpl implements IUserService {
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    //access_token失效时间 2小时
    public static long EXPIRE_TIME = 2 * 60 * 60 * 1000;
    @Autowired
    private UserDao userDao;

    @Override
    public long saveUser(User user) throws Exception {
        String salt = PBKDFUtil.generateSalt();
        user.setSalt(salt);
        String password = PBKDFUtil.getEncryptedPassword(user.getPassword(), salt);
        user.setPassword(password);
        user.setCreateDate(new Date());
        user.setUpdateDate(new Date());
        return userDao.saveUser(user);
    }

    /**
     * 查询登陆的用户名
     *
     * @param userName
     * @return
     */
    @Override
    public User getUserByName(String userName) {
        if (StringUtil.isEmpty(userName)) return null;
        return userDao.getUserByName(userName);
    }
    /**
     * 根据用户id查询用户
     *
     * @param userId
     * @return
     */
    @Override
    public User getUserById(long userId) {
        return userDao.getUserByUserId(userId);
    }
    /**
     * 用户登陆获取access_token
     *
     * @param user
     * @param password
     * @return
     * @throws Exception
     */
    @Override
    public String userLogin(User user, String password, String platform) {
        String accessToken = null;
        String salt = user.getSalt();
        try {
            String encryptedPwd = PBKDFUtil.getEncryptedPassword(password, salt);
            if (encryptedPwd.equals(user.getPassword())) {
                String data = user.getUserId() + ":" + (System.currentTimeMillis() + EXPIRE_TIME) + ":" + platform;
                accessToken = AesCiperTokenUtil.aesEncrypt(data);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return accessToken;
    }
}
