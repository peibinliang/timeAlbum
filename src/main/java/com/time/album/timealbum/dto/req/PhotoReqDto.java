package com.time.album.timealbum.dto.req;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 何巧莹
 * @ClassName PhotoReqDto
 * @Description
 * @since 2022/5/8
 */
@Data
public class PhotoReqDto implements Serializable {

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
