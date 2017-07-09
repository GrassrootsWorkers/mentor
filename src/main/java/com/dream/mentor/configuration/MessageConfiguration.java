package com.dream.mentor.configuration;

import com.dream.mentor.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by liuzhi on 2017/7/9.
 */
@Configuration
@PropertySource(value = "classpath:/message.properties", ignoreResourceNotFound = true)
public class MessageConfiguration {
    @Value("${captcha.error.msg}")
    private String captchaMsg;
    @Value("${system.error.msg}")
    private String systemErrorMsg;

    public String getCaptchaMsg() {
        return captchaMsg;
    }

    public void setCaptchaMsg(String captchaMsg) {
        this.captchaMsg = captchaMsg;
    }

    public String getSystemErrorMsg() {
        return systemErrorMsg;
    }

    public void setSystemErrorMsg(String systemErrorMsg) {
        this.systemErrorMsg = systemErrorMsg;
    }
}
