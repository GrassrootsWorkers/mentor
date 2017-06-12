package com.dream.mentor.bean.constant;

/**
 * Created by Administrator on 2017/5/5.
 */
public enum UserStatusEnum {
    NORMAL("normal"),//正常用户
    ARREARS("arrears"),//欠费用户
    INSUFFICIENT("insufficient"),//余额不足用户
    CLOSE("close");//用户关闭
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
