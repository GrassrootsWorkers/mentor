package com.dream.mentor.service.user;

import com.dream.mentor.bean.user.MentorExtraUser;
import com.dream.mentor.bean.user.MentorUser;
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
    public int saveUser(MentorUser mentorUser) throws Exception {
        String salt = PBKDFUtil.generateSalt();
        mentorUser.setSalt(salt);
        String password = PBKDFUtil.getEncryptedPassword(mentorUser.getPassword(), salt);
        mentorUser.setPassword(password);
        mentorUser.setCreateDate(new Date());
        mentorUser.setUpdateDate(new Date());
        mentorUser.setLoginDate(new Date());
        return userDao.saveUser(mentorUser);
    }

    /**
     * 查询登陆的用户名
     *
     * @param userName
     * @return
     */
    @Override
    public MentorUser getUserByName(String userName) {
        if (StringUtil.isEmpty(userName)) return null;
        return userDao.getUserByUserName(userName);
    }
    /**
     * 根据用户id查询用户
     *
     * @param userId
     * @return
     */
    @Override
    public MentorUser getUserById(long userId) {
        return userDao.getUserByUserId(userId);
    }

    @Override
    public MentorUser getUserByOpenId(String openId) {
        return userDao.getUserByOpenId(openId);
    }

    @Override
    public int updateMentorUser(MentorUser user) throws InvalidKeySpecException, NoSuchAlgorithmException {
        if(StringUtil.areNotEmpty(user.getPassword())){
            String salt = PBKDFUtil.generateSalt();
            user.setSalt(salt);
            String password = PBKDFUtil.getEncryptedPassword(user.getPassword(), salt);
            user.setPassword(password);
            return userDao.updateUser(user);
        }
        return 0;

    }

    /**
     * 用户登陆获取access_token
     *
     * @param mentorUser
     * @param password
     * @return
     * @throws Exception
     */
    @Override
    public String userLogin(MentorUser mentorUser, String password, String platform) {
        String accessToken = null;
        String salt = mentorUser.getSalt();
        try {
            String encryptedPwd = PBKDFUtil.getEncryptedPassword(password, salt);
            if (encryptedPwd.equals(mentorUser.getPassword())) {
                String data = mentorUser.getUserId() + ":" + (System.currentTimeMillis() + EXPIRE_TIME) + ":" + platform;
                accessToken = AesCiperTokenUtil.aesEncrypt(data);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return accessToken;
    }

    @Override
    public int saveExtraUser(MentorExtraUser extraUser) {
        userDao.saveExtraUserInfo(extraUser);
        return extraUser.getId();
    }

    @Override
    public MentorExtraUser getExtraUserByUserId(int userId) {
        return userDao.getExtraUserByUserId(userId);
    }
}
