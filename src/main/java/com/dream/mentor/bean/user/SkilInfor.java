package com.dream.mentor.bean.user;

import java.util.Date;

/**
 * Created by liuzhi on 2017/7/9.
 */
public class SkilInfor {
    private String industry;
    private String skilledIn;
    private String shortSkill;
    private Date workDate;
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

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
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
