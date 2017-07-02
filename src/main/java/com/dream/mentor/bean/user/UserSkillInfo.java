package com.dream.mentor.bean.user;

import com.dream.mentor.bean.BaseBean;

/**
 * Created by liuzhi on 2017/6/18.
 */
public class UserSkillInfo extends BaseBean{
    private String industry;
    private String skilledIn;//特长技能
    private String shortSkill;
    private int engagedAge;//从事计算机多少年
    private String company;
    private String personLabel;
    private String skillLabel;

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getSkilledIn() {
        return skilledIn;
    }

    public void setSkilledIn(String skilledIn) {
        this.skilledIn = skilledIn;
    }

    public String getShortSkill() {
        return shortSkill;
    }

    public void setShortSkill(String shortSkill) {
        this.shortSkill = shortSkill;
    }

    public int getEngagedAge() {
        return engagedAge;
    }

    public void setEngagedAge(int engagedAge) {
        this.engagedAge = engagedAge;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPersonLabel() {
        return personLabel;
    }

    public void setPersonLabel(String personLabel) {
        this.personLabel = personLabel;
    }

    public String getSkillLabel() {
        return skillLabel;
    }

    public void setSkillLabel(String skillLabel) {
        this.skillLabel = skillLabel;
    }
}
