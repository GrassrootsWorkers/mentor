package com.dream.mentor.cache;

/**
 * Created by Administrator on 2017/5/5.
 */
public interface IRedisCacheKey {
    String TEST_KEY = "test_key";
    String API_DAILY_INVOKE_TIME = "api_daily_time_%d_%d";// user_id apiId用户每天调用次数的缓存
    String API_ALL_INVOKE_TIME = "invoke_time_%d_%d";// user_id apiId用户每天调用次数的缓存
    String USER_LOGIN = "un_%s";//服务端记录用户的Id
    String COMMIT_ORDER_ID = "commit_order";//服务端记录用户的Id

}
