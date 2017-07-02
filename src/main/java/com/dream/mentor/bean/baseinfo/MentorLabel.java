package com.dream.mentor.bean.baseinfo;

import com.dream.mentor.bean.BaseBean;

/**
 * Created by liuzhi on 2017/6/18.
 */
public class MentorLabel extends BaseBean{

    private String labelName;
    private String labelType;//技能标签 个人标签
    private String labelDesc;

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getLabelType() {
        return labelType;
    }

    public void setLabelType(String labelType) {
        this.labelType = labelType;
    }

    public String getLabelDesc() {
        return labelDesc;
    }

    public void setLabelDesc(String labelDesc) {
        this.labelDesc = labelDesc;
    }
}
