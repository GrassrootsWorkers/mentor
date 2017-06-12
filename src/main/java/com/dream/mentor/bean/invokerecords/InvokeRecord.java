package com.dream.mentor.bean.invokerecords;

import com.dream.mentor.bean.BaseBean;

/**
 * Created by Administrator on 2017/5/4.
 */
public class InvokeRecord extends BaseBean {
    private String parameters;
    private long parametersHashCode;
    private int resultFlag;
    private String type;
    private long ip;
    private String invokeUrl;//接口url
    private long apiId;

    public long getApiId() {
        return apiId;
    }

    public void setApiId(long apiId) {
        this.apiId = apiId;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public long getParametersHashCode() {
        return parametersHashCode;
    }

    public void setParametersHashCode(long parametersHashCode) {
        this.parametersHashCode = parametersHashCode;
    }

    public String getInvokeUrl() {
        return invokeUrl;
    }

    public void setInvokeUrl(String invokeUrl) {
        this.invokeUrl = invokeUrl;
    }

    public int getResultFlag() {
        return resultFlag;
    }

    public void setResultFlag(int resultFlag) {
        this.resultFlag = resultFlag;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getIp() {
        return ip;
    }

    public void setIp(long ip) {
        this.ip = ip;
    }
}
