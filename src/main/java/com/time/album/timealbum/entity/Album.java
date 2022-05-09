package com.time.album.timealbum.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

/**
 * @author 何巧莹
 * @ClassName Album
 * @Description
 * @since 2022/5/9
 */
@Data
@TableName("tb_album")
public class Album extends Model<Album> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键 相册Id
     */
    @TableId(value = "album_id",type = IdType.AUTO)
    private Integer albumId;

    /**
     * 所属用户Id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 相册名称
     */
    @TableField("album_name")
    private String albumName;

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
    private String gmt_modify;

}
