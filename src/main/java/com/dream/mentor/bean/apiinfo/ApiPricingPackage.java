package com.dream.mentor.bean.apiinfo;

import com.dream.mentor.bean.BaseBean;

/**
 * Created by Administrator on 2017/5/16.
 */
public class ApiPricingPackage extends BaseBean {
    private String name;//套餐名称
    private long apiId;//接口id
    private double price;
    private int peakValue;//接口调用峰值，默认5/s
    private int chargeType;
    private String desc;//套餐描述
    private int maxTimes;//调用上限

    public int getMaxTimes() {
        return maxTimes;
    }

    public void setMaxTimes(int maxTimes) {
        this.maxTimes = maxTimes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getApiId() {
        return apiId;
    }

    public void setApiId(long apiId) {
        this.apiId = apiId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPeakValue() {
        return peakValue;
    }

    public void setPeakValue(int peakValue) {
        this.peakValue = peakValue;
    }

    public int getChargeType() {
        return chargeType;
    }

    public void setChargeType(int chargeType) {
        this.chargeType = chargeType;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
