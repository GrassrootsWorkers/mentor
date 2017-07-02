package com.dream.mentor.factory.apiprovider;

import com.dream.mentor.bean.QueryBean;
import com.dream.mentor.common.WebUtils;

import java.io.IOException;

/**
 * Created by Administrator on 2017/5/12.
 */
public class QDJKSearchFactory implements IApiProviderFactory {
    @Override
    public BaseApiProvider createProviderFactory() {
        return new QDJKSearch();
    }
}
class QDJKSearch implements BaseApiProvider{
    @Override
    public String doGet(String url, QueryBean baseBean, String charset) {
        String result = null;
        try {
            result = WebUtils.doGet(url,WebUtils.transBean2Map(baseBean),charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String doPost(String url, QueryBean baseBean, int connectTimeout, int readTimeout, String charSet) {
        String result = null;
        try {
            result = WebUtils.doPost(url,WebUtils.transBean2Map(baseBean),charSet,connectTimeout,readTimeout);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
