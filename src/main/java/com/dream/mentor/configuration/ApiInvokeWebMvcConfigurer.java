package com.dream.mentor.configuration;

import com.dream.mentor.interceptors.ApiInvokeTimesInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Administrator on 2017/5/4.
 */

@Configuration
public class ApiInvokeWebMvcConfigurer extends WebMvcConfigurerAdapter {
    @Bean
    ApiInvokeTimesInterceptor localInterceptor() {
        return new ApiInvokeTimesInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localInterceptor()).addPathPatterns("/api/*");
    }
}
