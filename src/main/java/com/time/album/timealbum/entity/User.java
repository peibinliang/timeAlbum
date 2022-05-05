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

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }
}
