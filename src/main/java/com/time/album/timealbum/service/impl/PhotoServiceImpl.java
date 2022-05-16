package com.time.album.timealbum.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.time.album.timealbum.dto.req.PhotoReqDto;
import com.time.album.timealbum.dto.resp.PhotoRespDto;
import com.time.album.timealbum.entity.Photo;
import com.time.album.timealbum.enums.LabelEnum;
import com.time.album.timealbum.mapper.PhotoMapper;
import com.time.album.timealbum.service.PhotoService;
import com.time.album.timealbum.utils.Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 何巧莹
 * @ClassName PhotoServiceImpl
 * @Description
 * @since 2022/5/8
 */
@Service
public class PhotoServiceImpl implements PhotoService {
    @Resource
    private PhotoMapper photoMapper;

    /**
     * 根据用户Id获取照片列表
     *
     * @param userId
     * @return
     */
    @Override
    public List<PhotoRespDto> listPhotoByUserId(Integer userId) {
        return photoMapper.listPhotoByUserId(userId);
    }

    /**
     * 根据相册Id获取照片
     *
     * @param albumId
     * @return
     */
    @Override
    public List<PhotoRespDto> listPhotoByAlbumId(Integer albumId) {
        return photoMapper.listPhotoByAlbumId(albumId);
    }

    /**
     * 新增照片
     *
     * @param photoReqDto
     * @return
     */
    @Override
    public boolean savePhoto(PhotoReqDto photoReqDto) {
        photoReqDto.setPhotoNo(Utils.generatePhotoNo());
        Photo photo = BeanUtil.toBean(photoReqDto, Photo.class);
        photoMapper.insert(photo);
        photoMapper.saveAlbumRelation(photoReqDto.getAlbumId(),photo.getPhotoId());
        return true;
    }

    /**
     * 获取照片
     *
     * @param photoId
     * @return
     */
    @Override
    public PhotoRespDto getPhotoByPhotoId(Integer photoId) {
        return BeanUtil.toBean(photoMapper.selectById(photoId),PhotoRespDto.class);
    }

    /**
     * 移除照片
     *
     * @param photoId
     * @return
     */
    @Override
    public boolean removePhoto(Integer photoId) {
        return photoMapper.removePhoto(photoId)>0;
    }

    /**
     * 搜索照片列表
     *
     * @param userId
     * @param search
     * @return
     */
    @Override
    public List<PhotoRespDto> searchPhotoListByUserId(Integer userId, String search) {
        if (LabelEnum.getTypeIdByTypeName(search)!=null){
            search = LabelEnum.getTypeIdByTypeName(search).toString();
        }
        return photoMapper.searchPhotoListByUserId(userId,search);
    }
}
