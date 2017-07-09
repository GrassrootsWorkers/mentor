package com.dream.mentor.bean.user;

import java.util.Date;

/**
 * Created by liuzhi on 2017/7/9.
 */
public class ExtraUserVo {
    private int userId;
    private String name;
    private String province;
    private String city;
    private String area;
    private Date graduateDate;
    private String school;
    private String major ;
    private String resumeUrl ;
    private String interests  ;
    private String industry;
    private String skilledIn;
    private String shortSkill;
    private Date workDate;
    private String company;
    private String personLabel;
    private String skillLabel;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Date getGraduateDate() {
        return graduateDate;
    }

    public void setGraduateDate(Date graduateDate) {
        this.graduateDate = graduateDate;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getResumeUrl() {
        return resumeUrl;
    }

    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

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
