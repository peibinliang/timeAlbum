package com.time.album.timealbum.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.time.album.timealbum.dto.resp.PhotoRespDto;
import com.time.album.timealbum.entity.Photo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PhotoMapper extends BaseMapper<Photo> {
    /**
     * 根据用户Id获取照片列表
     * @param userId
     * @return
     */
    List<PhotoRespDto> listPhotoByUserId(@Param("userId") Integer userId);

    /**
     * 根据相册Id获取照片列表
     * @param albumId
     * @return
     */
    List<PhotoRespDto> listPhotoByAlbumId(@Param("albumId") Integer albumId);

    /**
     * 保存照片和相册的关联关系
     * @param albumId
     * @param photoId
     * @return
     */
    Integer saveAlbumRelation(@Param("albumId") Integer albumId, @Param("photoId") Integer photoId);

    /**
     * 移除相片
     * @param photoId
     * @return
     */
    Integer removePhoto(@Param("photo") Integer photoId);

    /**
     * 搜索照片列表
     * @param userId
     * @param search
     * @return
     */
    List<PhotoRespDto> searchPhotoListByUserId(@Param("userId") Integer userId, @Param("search") String search);
}
