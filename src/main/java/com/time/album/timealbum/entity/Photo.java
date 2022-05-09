package com.time.album.timealbum.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 何巧莹
 * @ClassName Photo
 * @Description
 * @since 2022/5/8
 */
@Data
@TableName("tb_photo")
public class Photo extends Model<Photo> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键 照片Id
     */
    @TableId(value = "photo_id", type = IdType.AUTO)
    private Integer photoId;

    /**
     * 照片编号
     */
    @TableField("photo_no")
    private String photoNo;

    /**
     * 照片地址
     */
    @TableField("photo_url")
    private String photoUrl;

    /**
     * 照片标签
     */
    @TableField("photo_label")
    private Integer photoLabel;

    /**
     * 备注
     */
    @TableField("note")
    private String note;

    /**
     * 是否删除
     */
    @TableField("is_deleted")
    private Integer isDeleted;

    /**
     * 创建时间
     */
    @TableField("gmt_create")
    private Date gmtCreate;

    /**
     * 最后修改时间
     */
    @TableField("gmt_modify")
    private Date gmtModify;

    @Override
    protected Serializable pkVal() {
        return this.photoId;
    }
}
