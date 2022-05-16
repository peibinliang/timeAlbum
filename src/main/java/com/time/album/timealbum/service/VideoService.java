package com.time.album.timealbum.service;

import com.time.album.timealbum.dto.req.VideoReqDto;
import com.time.album.timealbum.dto.resp.VideoRespDto;

import java.util.List;

public interface VideoService {
    /**
     * 根据用户Id获取视频
     * @param userId
     * @return
     */
    List<VideoRespDto> listVideoByUserId(Integer userId);

    /**
     * 根据相册Id获取视频
     * @param albumId
     * @return
     */
    List<VideoRespDto> listVideoByAlbumId(Integer albumId);

    /**
     * 新增视频
     * @param videoReqDto
     * @return
     */
    boolean saveVideo(VideoReqDto videoReqDto);

    /**
     * 根据视频Id获取视频
     * @param videoId
     * @return
     */
    VideoRespDto getVideoByVideoId(Integer videoId);

    /**
     * 编辑视频信息
     * @param videoReqDto
     * @return
     */
    boolean modifyVideo(VideoReqDto videoReqDto);

    /**
     * 移除视频
     * @param videoId
     * @return
     */
    boolean removeVideo(Integer videoId);

    /**
     * 搜索视频列表
     * @param userId
     * @param search
     * @return
     */
    List<VideoRespDto> searchVideoListByUserId(Integer userId, String search);
}
