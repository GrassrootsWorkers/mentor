package com.dream.mentor.factory.apiprovider;

import com.dream.mentor.bean.QueryParameterBaseBean;

/**
 * Created by Administrator on 2017/5/12.
 */
public interface BaseApiProvider {
    String doGet(String url, QueryParameterBaseBean bean , String charSet);
    String doPost(String url,QueryParameterBaseBean bean,int connectTimeout, int readTimeout, String charSet);
}
