package com.dream.mentor.cache;

/**
 * Created by Administrator on 2017/5/5.
 */
public interface IRedisCache {

    /**
     * 缓存token
     * @param token
     * @return
     */
    boolean setWeChatAccessToken(String account,String token);

    /**
     * 获取token
     * @param account
     * @return
     */
    String getWeChatAccessToken(String account);

    /**
     * 缓存token
     * @param ticket
     * @return
     */
    boolean setWeChatTicket(String account,String ticket);

    /**
     * 获取token
     * @param account
     * @return
     */
    String getWeChatTicket(String account);

    /**
     * 缓存用户验证码
     * @param mobile
     * @param captcha
     * @return
     */
    boolean setCaptcha(String mobile ,String captcha);

    /**
     *
     * @param mobile
     * @return
     */
    String getCaptcha(String mobile);
}

