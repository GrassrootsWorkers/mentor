package com.dream.mentor.bean.constant;

/**
 * Created by Administrator on 2017/5/12.
 */

/**
 * 所有接口提供者的名录
 */
public enum ApiProviderDirectory {
    QDJK("qdjk");
    private String value;

    ApiProviderDirectory(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
