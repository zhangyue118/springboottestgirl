package com.yue.enums;

public enum ResultEnum {
    UNKNOWN_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    GAOZHONG(100,"还在上高中吧"),
    DAXUE(101,"你还在上大学吧"),
    BIYE(102,"你工作了？");

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    ResultEnum() {
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
