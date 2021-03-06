package com.time.album.timealbum.dto.resp;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 何巧莹
 * @ClassName UserRespDto
 * @Description
 * @since 2022/5/5
 */
@Data
public class UserRespDto implements Serializable {

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
    private String gmtCreate;

    /**
     * 最后修改时间
     */
    private String gmtModify;
}
