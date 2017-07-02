package com.dream.mentor.bean.teacher;

import com.dream.mentor.bean.BaseBean;

/**
 * 教师审查表
 * Created by liuzhi on 2017/6/18.
 */
public class TeacherAuth extends BaseBean{
    private String userImage;
    private String photosDate;
    private String observer;//见证人
    private String checkMark;//见证人备注
    private String observerMobile;//见证人手机号

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getPhotosDate() {
        return photosDate;
    }

    public void setPhotosDate(String photosDate) {
        this.photosDate = photosDate;
    }

    public String getObserver() {
        return observer;
    }

    public void setObserver(String observer) {
        this.observer = observer;
    }

    public String getCheckMark() {
        return checkMark;
    }

    public void setCheckMark(String checkMark) {
        this.checkMark = checkMark;
    }

    public String getObserverMobile() {
        return observerMobile;
    }

    public void setObserverMobile(String observerMobile) {
        this.observerMobile = observerMobile;
    }
}
