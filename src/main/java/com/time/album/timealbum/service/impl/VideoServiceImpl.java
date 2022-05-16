package com.time.album.timealbum.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.time.album.timealbum.dto.req.VideoReqDto;
import com.time.album.timealbum.dto.resp.VideoRespDto;
import com.time.album.timealbum.entity.Video;
import com.time.album.timealbum.enums.LabelEnum;
import com.time.album.timealbum.mapper.VideoMapper;
import com.time.album.timealbum.service.VideoService;
import com.time.album.timealbum.utils.Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 何巧莹
 * @ClassName VideoServiceImpl
 * @Description
 * @since 2022/5/9
 */
@Service
public class VideoServiceImpl implements VideoService {
    @Resource
    private VideoMapper videoMapper;

    /**
     * 根据用户Id获取视频
     *
     * @param userId
     * @return
     */
    @Override
    public List<VideoRespDto> listVideoByUserId(Integer userId) {
        return videoMapper.listVideoByUserId(userId);
    }

    /**
     * 根据相册Id获取视频
     *
     * @param albumId
     * @return
     */
    @Override
    public List<VideoRespDto> listVideoByAlbumId(Integer albumId) {
        return videoMapper.listVideoByAlbumId(albumId);
    }

    /**
     * 新增视频
     *
     * @param videoReqDto
     * @return
     */
    @Override
    public boolean saveVideo(VideoReqDto videoReqDto) {
        videoReqDto.setVideoNo(Utils.generateVideoNo());
        Video video = BeanUtil.toBean(videoReqDto, Video.class);
        videoMapper.insert(video);
        videoMapper.saveVideoRelation(videoReqDto.getAlbumId(),video.getVideoId());
        return false;
    }

    /**
     * 根据视频Id获取视频
     *
     * @param videoId
     * @return
     */
    @Override
    public VideoRespDto getVideoByVideoId(Integer videoId) {
        return BeanUtil.toBean(videoMapper.selectById(videoId),VideoRespDto.class);
    }

    /**
     * 编辑视频信息
     *
     * @param videoReqDto
     * @return
     */
    @Override
    public boolean modifyVideo(VideoReqDto videoReqDto) {
        return videoMapper.updateById(BeanUtil.toBean(videoReqDto,Video.class))>0;
    }

    /**
     * 移除视频
     *
     * @param videoId
     * @return
     */
    @Override
    public boolean removeVideo(Integer videoId) {
        return videoMapper.removeVideo(videoId)>0;
    }

    /**
     * 搜索视频列表
     *
     * @param userId
     * @param search
     * @return
     */
    @Override
    public List<VideoRespDto> searchVideoListByUserId(Integer userId, String search) {
        if (LabelEnum.getTypeIdByTypeName(search)!=null){
            search = LabelEnum.getTypeIdByTypeName(search).toString();
        }
        return videoMapper.searchVideoListByUserId(userId,search);
    }
}
