package com.dream.mentor.cache;

import com.dream.mentor.common.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Calendar;

/**
 * Created by Administrator on 2017/5/5.
 */
@Service
public class RedisCacheServiceImpl implements IRedisCache {
    Logger logger = LoggerFactory.getLogger(RedisCacheServiceImpl.class);
    @Autowired
    JedisPool jedisPool;

    @Override
    public boolean setApiDailyInvokeTime(long userId, long apiId) {
        String key = String.format(IRedisCacheKey.API_DAILY_INVOKE_TIME, userId, apiId);
        Jedis jedis = jedisPool.getResource();
        jedis.incr(key);
        jedis.expire(key, getExpireSeconds());
        jedis.close();
        return true;
    }

    @Override
    public int getApiDailyInvokeTime(long userId, long apiId) {
        String key = String.format(IRedisCacheKey.API_DAILY_INVOKE_TIME, userId, apiId);
        Jedis jedis = jedisPool.getResource();
        String times = jedis.get(key);
        if (StringUtil.areNotEmpty(times)) {
            return Integer.parseInt(times);
        } else {
            return 0;
        }

    }

    @Override
    public boolean setApiInvokeTime(long userId, long apiId) {
        String key = String.format(IRedisCacheKey.API_ALL_INVOKE_TIME, userId, apiId);
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.incr(key);
        } finally {
            jedis.close();
        }
        return true;
    }

    @Override
    public int getApiInvokeTime(long userId, long apiId) {
        String key = String.format(IRedisCacheKey.API_ALL_INVOKE_TIME, userId, apiId);
        Jedis jedis = jedisPool.getResource();
        try {
            String times = jedis.get(key);
            return Integer.parseInt(times);
        } catch (Exception e) {
            logger.error("getApiInvokeTime error userId ={} apiId{}", userId, apiId);
        } finally {
            jedis.close();
        }
        return 0;
    }

    @Override
    public boolean clearApiInvokeTime(long userId, long apiId) {
        String key = String.format(IRedisCacheKey.API_ALL_INVOKE_TIME, userId, apiId);
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.del(key);
            return true;
        } catch (Exception e) {
            logger.error("clearApiInvokeTime error userId={} apiId={}", userId, apiId);
        } finally {
            jedis.close();
        }

        return false;
    }

    @Override
    public boolean userServerLogin(String userName, long userId) {
        String key = String.format(IRedisCacheKey.USER_LOGIN, userName);
        Jedis jedis = jedisPool.getResource();
        jedis.set(key, userId + "");
        jedis.expire(key, 7 * 24 * 60 * 60);
        jedis.close();
        return false;
    }

    @Override
    public long getLoginUserId(String userName) {
        if (StringUtil.isEmpty(userName)) {
            return 0;
        }
        Jedis jedis = jedisPool.getResource();
        try {
            String userId = jedis.get(String.format(IRedisCacheKey.USER_LOGIN, userName));
            if (StringUtil.areNotEmpty(userId)) {
                return Long.parseLong(userId);
            } else {
                return 0;
            }

        } finally {
            jedis.close();
        }
    }

    @Override
    public boolean cacheCommitOrderId(long orderId) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.lpush(IRedisCacheKey.COMMIT_ORDER_ID, orderId + "");
        } finally {
            jedis.close();
        }
        return true;
    }

    @Override
    public long getCacheCommitOrderId() {
        Jedis jedis = jedisPool.getResource();
        try {
            String orderId = jedis.rpop(IRedisCacheKey.COMMIT_ORDER_ID);
            if(StringUtil.isNotEmpty(orderId)){
                return Long.parseLong(orderId);
            }
        } finally {
            jedis.close();
        }
        return 0;
    }

    //获取当前时间到凌晨0点的秒数
    private int getExpireSeconds() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        Long second = (calendar.getTimeInMillis() - System.currentTimeMillis()) / 1000;
        return second.intValue();
    }
}
