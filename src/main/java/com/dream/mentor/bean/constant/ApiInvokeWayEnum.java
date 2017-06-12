package com.dream.mentor.bean.constant;

/**
 * Created by Administrator on 2017/5/12.
 */
public enum ApiInvokeWayEnum {
    YEAR(4),
    MONTH(3),
    WEEK(2),
    DAILY(1),
    TIME(0);

    private int value;

    ApiInvokeWayEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
