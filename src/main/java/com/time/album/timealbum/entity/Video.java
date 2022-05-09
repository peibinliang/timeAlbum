package com.time.album.timealbum.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * @author 何巧莹
 * @ClassName Video
 * @Description
 * @since 2022/5/9
 */
@Data
@TableName("tb_video")
public class Video extends Model<Video> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键 视频Id
     */
    @TableId(value = "video_id",type = IdType.AUTO)
    private Integer videoId;

    /**
     * 视频编号
     */
    @TableField("video_no")
    private String videoNo;

    /**
     * 视频地址
     */
    @TableField("video_url")
    private String videoUrl;

    /**
     * 视频标签
     */
    @TableField("video_label")
    private String videoLabel;

    /**
     * 视频备注
     */
    @TableField("note")
    private String note;

    /**
     * 是否删除
     */
    @TableField("is_deleted")
    private Integer is_deleted;

    /**
     * 创建时间
     */
    @TableField("gmt_create")
    private String gmtCreate;

    /**
     * 最后修改时间
     */
    @TableField("gmt_modify")
    private String gmtModify;
}
