package com.time.album.timealbum.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 何巧莹
 * @ClassName User
 * @Description
 * @since 2022/5/5
 */
@Data
@TableName(value = "tb_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键 用户Id
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户名称
     */
    @TableField("user_name")
    private String userName;

    /**
     * 手机号码
     */
    @TableField("phone")
    private String phone;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 真实姓名
     */
    @TableField("real_name")
    private String realName;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 用户角色
     */
    @TableField("role")
    private Integer role;

    /**
     * 创建时间/注册时间
     */
    @TableField("gmt_create")
    private String gmtCreate;

    /**
     * 最后修改时间
     */
    @TableField("gmt_modify")
    private String gmtModify;

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }
}
