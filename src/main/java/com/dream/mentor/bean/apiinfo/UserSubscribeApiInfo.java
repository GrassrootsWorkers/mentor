package com.dream.mentor.bean.apiinfo;

import com.dream.mentor.bean.BaseBean;

import java.util.Date;

/**
 * Created by Administrator on 2017/5/3.
 */
public class UserSubscribeApiInfo extends BaseBean {
    private long apiId;//api接口的id
    private long apiProviderId;//接口提供者Id
    private long usedTimes;//已经调用的次数
    private int allowTimes;
    private int peekValue;
    private Date expireDate;

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public long getApiId() {
        return apiId;
    }

    public void setApiId(long apiId) {
        this.apiId = apiId;
    }

    public long getApiProviderId() {
        return apiProviderId;
    }

    public void setApiProviderId(long apiProviderId) {
        this.apiProviderId = apiProviderId;
    }

    public long getUsedTimes() {
        return usedTimes;
    }

    public void setUsedTimes(long usedTimes) {
        this.usedTimes = usedTimes;
    }
    public int getAllowTimes() {
        return allowTimes;
    }

    public void setAllowTimes(int allowTimes) {
        this.allowTimes = allowTimes;
    }

    public int getPeekValue() {
        return peekValue;
    }

    public void setPeekValue(int peekValue) {
        this.peekValue = peekValue;
    }
}
