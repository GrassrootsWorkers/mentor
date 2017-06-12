package com.dream.mentor.cache;

/**
 * Created by Administrator on 2017/5/5.
 */
public interface IRedisCache {
    /**
     * 设置一个接口次数加1
     * @param userId 用户id
     * @param apiId 要调用接口的Id
     * @return
     */
    boolean setApiDailyInvokeTime(long userId,long apiId);

    /**
     * 获取用户调用某个接口次数
     * @param userId
     * @param apiId
     * @return
     */
    int getApiDailyInvokeTime(long userId,long apiId);

    /**
     * 设置一个接口调用的总次数
     * @param userId
     * @param apiId
     * @return
     */
    boolean setApiInvokeTime(long userId,long apiId);

    /**
     * 获取一个接口调用的总次数
     * @param userId
     * @param apiId
     * @return
     */
    int getApiInvokeTime(long userId,long apiId);

    /**
     * 清除一个接口的调用次数
     * @param userId
     * @param apiId
     * @return
     */
    boolean clearApiInvokeTime(long userId, long apiId);
    /**
     * 服务端记录用户登陆的用户Id
     * @param userName
     * @param userId 失效时间为一周
     * @return
     */
    boolean userServerLogin(String userName, long userId);

    /**
     * 获取登陆用户的Id
     * @param userName
     * @return
     */
    long getLoginUserId(String userName);

    /**
     *
     * @param orderId
     * @return
     */
    boolean cacheCommitOrderId(long orderId);

    /**
     * 一个一个去处缓存的orderId进行处理
     * @return
     */
    long getCacheCommitOrderId();
}

