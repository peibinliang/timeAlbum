package com.time.album.timealbum.dto.req;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author 何巧莹
 * @ClassName AlbumReqDto
 * @Description
 * @since 2022/5/9
 */
@Data
public class AlbumReqDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键 相册Id
     */
    private Integer albumId;

    /**
     * 所属用户Id
     */
    private Integer userId;

    /**
     * 相册名称
     */
    private String albumName;

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
    private String gmt_modify;

    /**
     * 用户Id列表
     */
    private List<Integer> userIdList;

}
