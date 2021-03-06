package com.dream.mentor.bean.constant;

/**
 * Created by Administrator on 2017/5/5.
 */
public enum UserStatusEnum {
    USING("1"),//启用
    STOP("0");//停用

    private String value;

    UserStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static void main(String[]args){
        for(UserStatusEnum name: UserStatusEnum.values()){
            System.out.print(name+"_"+name.getValue());
        }
    }
}
