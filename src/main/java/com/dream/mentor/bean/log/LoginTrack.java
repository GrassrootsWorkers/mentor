package com.dream.mentor.bean.log;

/**
 * Created by liuzhi on 2017/6/18.
 */
public class LoginTrack {
    private int userId;
    private int loginIp;
    private String operator;
    private String content;
    private String loginType;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(int loginIp) {
        this.loginIp = loginIp;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
