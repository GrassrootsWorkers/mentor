package com.dream.mentor.bean.teacher;

import com.dream.mentor.bean.BaseBean;

import java.util.Date;

/**
 * 成为老师的工作技能表
 * Created by liuzhi on 2017/6/18.
 */
public class TeacherExperience extends BaseBean {

    private String companyName;
    private String mainRes;//在公司的主要职责
    private String skillIds;//技能id串
    private String skills;//技能串
    private Date beginDate;
    private Date endDate;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getMainRes() {
        return mainRes;
    }

    public void setMainRes(String mainRes) {
        this.mainRes = mainRes;
    }

    public String getSkillIds() {
        return skillIds;
    }

    public void setSkillIds(String skillIds) {
        this.skillIds = skillIds;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
