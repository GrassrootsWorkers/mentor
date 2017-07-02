package com.dream.mentor.factory.apiprovider;

import com.dream.mentor.bean.QueryBean;

/**
 * Created by Administrator on 2017/5/12.
 */
public interface BaseApiProvider {
    String doGet(String url, QueryBean bean , String charSet);
    String doPost(String url, QueryBean bean, int connectTimeout, int readTimeout, String charSet);
}
