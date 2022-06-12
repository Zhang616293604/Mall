package com.example.se_time.mall.pojo;

public enum  ResponseCode {

    //封装响应操作

    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERROR"),
    UNLOGIN(2,"UNLOGIN");

    private final int code;
    private final String desc;

    private ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
