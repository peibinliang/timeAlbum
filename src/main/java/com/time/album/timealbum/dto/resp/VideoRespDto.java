package com.time.album.timealbum.dto.resp;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 何巧莹
 * @ClassName VideoRespDto
 * @Description
 * @since 2022/5/9
 */
@Data
public class VideoRespDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键 视频Id
     */
    private Integer videoId;

    /**
     * 视频编号
     */
    private String videoNo;

    /**
     * 视频地址
     */
    private String videoUrl;

    /**
     * 视频标签
     */
    private Integer videoLabel;

    /**
     * 标签名称
     */
    private String labelName;

    /**
     * 视频备注
     */
    private String note;

    /**
     * 是否删除
     */
    private Integer is_deleted;

    /**
     * 创建时间
     */
    private String gmtCreate;

    /**
     * 最后修改时间
     */
    private String gmtModify;
}
