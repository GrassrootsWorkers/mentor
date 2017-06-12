package com.dream.mentor.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/5/9.
 */
@Configuration
public class ThreadPoolConfiguration {


    @Bean
    public ThreadPoolExecutor getThreadPool(@Value("${spring.thread.minSize}") int corePoolSize,
                                            @Value("${spring.thread.maxSize}") int maximumPoolSize,
                                            @Value("${spring.thread.keepAliveTime}") long keepAliveTime) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.MICROSECONDS, new ArrayBlockingQueue<Runnable>(100), new ThreadPoolExecutor.DiscardPolicy());
        return threadPool;
    }
}
