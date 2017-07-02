package com.dream.mentor.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


/**
 * Created by Administrator on 2017/5/5.
 */
@Configuration
@PropertySource("classpath:application-redis.properties")
public class RedisPoolConfiguration {

    @Value("${redis.maxActive}")
    private int maxTotal;
    @Value("${redis.maxIdle}")
    private int maxIdle;
    @Value("${redis.minIdle}")
    private int minIdle;
    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private int port;
    @Value("${redis.timeout}")
    private int timeout;
    @Value("${redis.password}")
    private String password;
   /* @Value("${redis.testOnBorrow}")
    private boolean testOnBorrow;*/

    @Bean
    public JedisPool getPool() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        //poolConfig.setTestOnBorrow(testOnBorrow);
        poolConfig.setMinIdle(minIdle);
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMaxTotal(maxTotal);
        JedisPool jedisPool = new JedisPool(poolConfig, host, port, timeout,password);
        return jedisPool;
    }
}
