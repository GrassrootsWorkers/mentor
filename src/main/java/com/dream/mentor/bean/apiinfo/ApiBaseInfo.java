package com.dream.mentor.bean.apiinfo;

import com.dream.mentor.bean.BaseBean;

/**
 * Created by Administrator on 2017/5/10.
 */
public class ApiBaseInfo extends BaseBean {
    private int categoryId;
    private String apiName;
    private String apiDesc;
    private String apiUrl;
    private int apiStatus;//0:停用 1：启用
    private String icon;
    private int appCount;//多少用户购买
    private int clickedCount;//浏览数量
    private int collectCount;//收藏数量
    private int reviewCount;//评论数量
    private String dataType;//返回数据的类型 json,xml,text
    private String invokeMethod;//调用方式 GET/POST
    private String inputParameters;//入参列表key=value(value=类型:默认值:示例值:是否必填:描述),key=value
    private String outputParameters;//出参 key=value(value=类型:默认值:示例值),key=value
    private String invokeDemo;//调用url示例
    private String resultDemo;//返回数据示例

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getInvokeMethod() {
        return invokeMethod;
    }

    public void setInvokeMethod(String invokeMethod) {
        this.invokeMethod = invokeMethod;
    }

    public String getInputParameters() {
        return inputParameters;
    }

    public void setInputParameters(String inputParameters) {
        this.inputParameters = inputParameters;
    }

    public String getOutputParameters() {
        return outputParameters;
    }

    public void setOutputParameters(String outputParameters) {
        this.outputParameters = outputParameters;
    }

    public String getInvokeDemo() {
        return invokeDemo;
    }

    public void setInvokeDemo(String invokeDemo) {
        this.invokeDemo = invokeDemo;
    }

    public String getResultDemo() {
        return resultDemo;
    }

    public void setResultDemo(String resultDemo) {
        this.resultDemo = resultDemo;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getApiDesc() {
        return apiDesc;
    }

    public void setApiDesc(String apiDesc) {
        this.apiDesc = apiDesc;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public int getApiStatus() {
        return apiStatus;
    }

    public void setApiStatus(int apiStatus) {
        this.apiStatus = apiStatus;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getAppCount() {
        return appCount;
    }

    public void setAppCount(int appCount) {
        this.appCount = appCount;
    }

    public int getClickedCount() {
        return clickedCount;
    }

    public void setClickedCount(int clickedCount) {
        this.clickedCount = clickedCount;
    }

    public int getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(int collectCount) {
        this.collectCount = collectCount;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }
}
