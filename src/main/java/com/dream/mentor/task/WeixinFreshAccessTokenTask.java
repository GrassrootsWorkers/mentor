package com.dream.mentor.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dream.mentor.cache.IRedisCache;
import com.dream.mentor.common.StringUtil;
import com.dream.mentor.common.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by liuzhi on 2016/10/3.
 */
@Component
public class WeixinFreshAccessTokenTask {
    private static Logger log = LoggerFactory.getLogger(WeixinFreshAccessTokenTask.class);
    @Resource
    IRedisCache redisCache;
    @Scheduled(cron = "0 59 0/1 * * ?")
    public void execute() {
        String weiXinAccount = "mentor";
        String[] accounts = weiXinAccount.split(",");
        for (String account : accounts) {
            try {
                String  token = cacheAccessToken(account);
                if (StringUtil.areNotEmpty(token)) {
                    cacheTicket(account, token);
                }
            } catch (IOException e) {
                log.error("WeiXinFreshAccessTokenService={}",e.getMessage());
            }
        }

    }

    public String cacheAccessToken(String account) {
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx81cb60beb04da0f8&secret=1434c51fa5c7ed2479a8395a22e16bb5";
        try {
            String responseJson = WebUtils.doGet(url, null, WebUtils.DEFAULT_CHARSET);
            JSONObject jsonObject = JSON.parseObject(responseJson);
            String accessToken = (String) jsonObject.get("access_token");
            redisCache.setWeChatAccessToken( account, accessToken);
            return accessToken;
        } catch (Exception e) {
            log.error("account={} get access token error url ={}", account, url);
            return null;
        }
    }

    public void cacheTicket(String account,String accessToken) throws IOException {
        try {
            String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + accessToken + "&type=jsapi";
            String responseJson = WebUtils.doGet(url, null, WebUtils.DEFAULT_CHARSET);
            JSONObject jsonObject = JSON.parseObject(responseJson);
            String ticket = (String) jsonObject.get("ticket");
            redisCache.setWeChatTicket(account, ticket);
        } catch (Exception e) {
            log.error("account={} get ticket error url ={}", account);
        }

    }

}

