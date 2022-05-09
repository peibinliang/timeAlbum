package com.time.album.timealbum.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.time.album.timealbum.dto.resp.AlbumRespDto;
import com.time.album.timealbum.dto.resp.UserRespDto;
import com.time.album.timealbum.entity.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlbumMapper extends BaseMapper<Album> {
    /**
     * 相册列表
     * @param userId
     * @return
     */
    List<AlbumRespDto> lsitAlbum(@Param("userId") Integer userId);

    /**
     * 获取相册成员
     * @param albumId
     * @return
     */
    List<UserRespDto> listUserByAlbumId(@Param("albumId") Integer albumId);
}
