package com.time.album.timealbum.service;

import com.time.album.timealbum.dto.req.PhotoReqDto;
import com.time.album.timealbum.dto.resp.PhotoRespDto;

import java.util.List;

public interface PhotoService {
    /**
     * 根据用户Id获取照片列表
     * @param userId
     * @return
     */
    List<PhotoRespDto> listPhotoByUserId(Integer userId);

    /**
     * 根据相册Id获取照片
     * @param albumId
     * @return
     */
    List<PhotoRespDto> listPhotoByAlbumId(Integer albumId);

    /**
     * 新增照片
     * @param photoReqDto
     * @return
     */
    boolean savePhoto(PhotoReqDto photoReqDto);

    /**
     * 获取照片
     * @param photoId
     * @return
     */
    PhotoRespDto getPhotoByPhotoId(Integer photoId);

    /**
     * 移除照片
     * @param photoId
     * @return
     */
    boolean removePhoto(Integer photoId);

    /**
     * 搜索照片列表
     * @param userId
     * @param search
     * @return
     */
    List<PhotoRespDto> searchPhotoListByUserId(Integer userId, String search);
}
