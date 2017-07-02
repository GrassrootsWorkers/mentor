package com.dream.mentor.cache;

/**
 * Created by Administrator on 2017/5/5.
 */
public interface IRedisCacheKey {
    String WX_ACCESS_TOKEN_KEY = "token_%s";
    String WX_ACCESS_TICKET_KEY = "ticket%s";
    String CAPTCHA="captcha_%s";


}
