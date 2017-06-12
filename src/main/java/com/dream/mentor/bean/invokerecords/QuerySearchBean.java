package com.dream.mentor.bean.invokerecords;

import com.dream.mentor.bean.QueryParameterBaseBean;

/**
 * Created by Administrator on 2017/5/4.
 */
public class QuerySearchBean extends QueryParameterBaseBean {
    private String key;//用户输入的关键字
    private String type;//用户选择的查询类型 //公司 风险信息 知识产权
    private Long userId;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
