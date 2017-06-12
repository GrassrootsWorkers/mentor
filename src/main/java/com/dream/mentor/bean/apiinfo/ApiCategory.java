package com.dream.mentor.bean.apiinfo;

import com.dream.mentor.bean.BaseBean;

/**
 * Created by Administrator on 2017/5/10.
 */
public class ApiCategory extends BaseBean {
    private String name;
    private String icon;
    private long fatherId;//父分类id
    private String fatherName;//父分类名称

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public long getFatherId() {
        return fatherId;
    }

    public void setFatherId(long fatherId) {
        this.fatherId = fatherId;
    }
}
