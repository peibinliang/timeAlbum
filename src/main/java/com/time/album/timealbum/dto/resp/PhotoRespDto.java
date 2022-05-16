package com.time.album.timealbum.dto.resp;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 何巧莹
 * @ClassName PhotoRespDto
 * @Description
 * @since 2022/5/8
 */
@Data
public class PhotoRespDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键 照片Id
     */
    private Integer photoId;

    /**
     * 照片编号
     */
    private String photoNo;

    /**
     * 照片地址
     */
    private String photoUrl;

    /**
     * 照片标签
     */
    private Integer photoLabel;

    /**
     * 标签名称
     */
    private String labelName;

    /**
     * 备注
     */
    private String note;

    /**
     * 是否删除
     */
    private Integer isDeleted;

    /**
     * 创建时间
     */
    private String gmtCreate;

    /**
     * 最后修改时间
     */
    private String gmtModify;
}
