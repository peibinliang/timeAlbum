package com.time.album.timealbum.dto.req;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 何巧莹
 * @ClassName UserReqDto
 * @Description 用户请求对象
 * @since 2022/5/5 21:37
 */
@Data
public class UserReqDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键 用户Id
     */
    private Integer userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 账号
     */
    private String account;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户角色
     */
    private Integer role;

    /**
     * 创建时间/注册时间
     */
    private Date gmtCreate;

    /**
     * 最后修改时间
     */
    private Date gmtModify;

    /**
     * 相册Id
     */
    private Integer albumId;
}
