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

    //获取当前时间到凌晨0点的秒数
    private int getExpireSeconds() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        Long second = (calendar.getTimeInMillis() - System.currentTimeMillis()) / 1000;
        return second.intValue();
    }

    @Override
    public boolean setWeChatAccessToken(String account, String token) {
        Jedis jedis = jedisPool.getResource();
        try {
            String key = String.format(IRedisCacheKey.WX_ACCESS_TOKEN_KEY, account);
            jedis.set(key, token);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }
        return false;

    }

    @Override
    public String getWeChatAccessToken(String account) {
        Jedis jedis = jedisPool.getResource();
        try {
            String key = String.format(IRedisCacheKey.WX_ACCESS_TOKEN_KEY, account);
            return jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }
        return null;
    }

    @Override
    public boolean setWeChatTicket(String account, String ticket) {
        Jedis jedis = jedisPool.getResource();
        try {
            String key = String.format(IRedisCacheKey.WX_ACCESS_TICKET_KEY, account);
            jedis.set(key, ticket);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }
        return false;
    }

    @Override
    public String getWeChatTicket(String account) {
        Jedis jedis = jedisPool.getResource();
        try {
            String key = String.format(IRedisCacheKey.WX_ACCESS_TICKET_KEY, account);
            return jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }
        return null;
    }

    @Override
    public boolean setCaptcha(String mobile, String captcha) {
        Jedis jedis = jedisPool.getResource();
        try {
            String key = String.format(IRedisCacheKey.CAPTCHA, mobile);

            jedis.set(key, captcha);
            jedis.expire(key,30*60);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }
        return false;
    }

    @Override
    public String getCaptcha(String mobile) {
        Jedis jedis = jedisPool.getResource();
        try {
            String key = String.format(IRedisCacheKey.CAPTCHA, mobile);
            return jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }
        return null;
    }
}
