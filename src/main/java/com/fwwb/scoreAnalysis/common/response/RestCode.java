package com.fwwb.scoreAnalysis.common.response;

/**
 * Created by Administrator on 2016/3/1.
 */
public enum RestCode {

    /** 200-299:操作成功返回类型*/
    SUCCESS(200, "请求成功"),
    /** 300-399:请求参数不完整或不正确*/
    OPTION_INCORRECT(300,"请求的目标内容不完整"),
    LOGIN_INVALID(301,"账号或密码不正确"),
    /** 400-499:请求资源不正确*/
    TARGET_IS_INCOMPLETE(400,"操作不正确"),
    TOKEN_LACK(401,"需要登录"),
    OPTION_FORBIDDEN(403,"没有操作权限"),
    TARGET_IS_NULL(404, "请求内容不存在"),
    TARGET_EXISTED(409,"对象已经存在"),
    /** 500:服务器异常*/
    ERROR(500,"服务器执行操作发生异常"),
    ID_ERROR(999,"身份证号码不合法");

    RestCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private int code;

    private String msg;

    public RestCode get(int code) {
        for (RestCode c : RestCode.values()) {
            if (c.getCode() == code) {
                return c;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
