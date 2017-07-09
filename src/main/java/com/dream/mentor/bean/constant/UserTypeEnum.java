package com.dream.mentor.bean.constant;

/**
 * Created by Administrator on 2017/5/5.
 */
public enum UserTypeEnum {
    ALL("ST"),//老师兼学生
    TEACHER("T"),//老师
    STUDENT("S");//学生
    private String value;

    UserTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static void main(String[]args){
        for(UserTypeEnum name: UserTypeEnum.values()){
            System.out.print(name+"_"+name.getValue());
        }
    }
}
