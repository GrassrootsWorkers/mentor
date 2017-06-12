package com.dream.mentor.bean.constant;

/**
 * Created by Administrator on 2017/5/16.
 */
public enum ApiOrderStatusEnum {
    TIMEOUT("TIMEOUT"),
    SUCCESS("SUCCESS"),
    WAITING("WAITING"),
    PAID("PAID");

    private String value;

    ApiOrderStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
