package com.dream.mentor.bean.trade;

import com.dream.mentor.bean.BaseBean;

/**
 * Created by Administrator on 2017/5/15.
 */
public class ApiOrders extends BaseBean {
    private String orderNo;
    private String tradeNo;
    private String apiName;
    private long apiId;
    private long pricePackageId;//套餐id
    private String pricePackageName;
    private double pricePackagePrice;
    private int pricePackageCount;
    private double totalPrice;
    private String orderStatus;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public long getPricePackageId() {
        return pricePackageId;
    }

    public void setPricePackageId(long pricePackageId) {
        this.pricePackageId = pricePackageId;
    }

    public String getPricePackageName() {
        return pricePackageName;
    }

    public void setPricePackageName(String pricePackageName) {
        this.pricePackageName = pricePackageName;
    }

    public double getPricePackagePrice() {
        return pricePackagePrice;
    }

    public void setPricePackagePrice(double pricePackagePrice) {
        this.pricePackagePrice = pricePackagePrice;
    }

    public int getPricePackageCount() {
        return pricePackageCount;
    }

    public void setPricePackageCount(int pricePackageCount) {
        this.pricePackageCount = pricePackageCount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public long getApiId() {
        return apiId;
    }

    public void setApiId(long apiId) {
        this.apiId = apiId;
    }
}
