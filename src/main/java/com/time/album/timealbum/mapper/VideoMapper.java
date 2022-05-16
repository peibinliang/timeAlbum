package com.time.album.timealbum.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.time.album.timealbum.dto.resp.VideoRespDto;
import com.time.album.timealbum.entity.Video;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoMapper extends BaseMapper<Video> {
    /**
     * 根据用户Id获取视频
     * @param userId
     * @return
     */
    List<VideoRespDto> listVideoByUserId(@Param("userId") Integer userId);

    /**
     * 根据相册Id获取视频
     * @param albumId
     * @return
     */
    List<VideoRespDto> listVideoByAlbumId(@Param("albumId") Integer albumId);

    /**
     * 新增视频和相册的关联关系
     * @param albumId
     * @param videoId
     * @return
     */
    Integer saveVideoRelation(@Param("albumId") Integer albumId, @Param("videoId") Integer videoId);

    /**
     * 移除视频
     * @param videoId
     * @return
     */
    Integer removeVideo(@Param("videoId") Integer videoId);

    /**
     * 视频搜索
     * @param userId
     * @param search
     * @return
     */
    List<VideoRespDto> searchVideoListByUserId(Integer userId, String search);
}
