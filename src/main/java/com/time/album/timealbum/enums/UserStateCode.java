package com.time.album.timealbum.enums;

/**
 * @author liangpeibin
 * @ClassName UserStateCode
 * @Description 用户业务异常码
 * @since 2022/5/2 20:46
 */
public enum UserStateCode {

    /**
     * 用户业务异常码,状态码以BU开头,如BU10001,依次递增
     */
    BU10001("用户名已存在"),
    BU10002("用户不存在"),
    BU10003("账号或者密码错误"),
    BU10004("手机号错误"),
    BU10005("手机号格式错误"),
    BU10006("密码错误"),
    BU10007("这已经是最后一页了")
    ;

    private final String msg;


    UserStateCode(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
