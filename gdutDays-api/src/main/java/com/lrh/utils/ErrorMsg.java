package com.lrh.utils;

public enum ErrorMsg {
    SYSTEM_ERROR(999,"系统错误"),
    ACCOUNT_PASSWORD_ERROR(1001,"账号或密码错误"),
    NO_LOGIN(1002,"用户未登录"),
    REGISTER_PARAM_ERROR(1003,"请填写完整注册信息"),
    REGISTER_FAIL(1004,"该账号已被注册"),
    USER_EXPIRE(1005,"用户已过期，请重新登录"),
    TOKEN_ERROR(1006,"token不合法"),
    FILE_ERROR(1007,"图片格式错误"),
    PASSWORD_ERROR(1009,"旧密码错误");

    private Integer code;
    private String message;

    ErrorMsg(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
