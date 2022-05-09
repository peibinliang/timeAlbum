package com.time.album.timealbum.service;

import com.time.album.timealbum.dto.resp.AlbumRespDto;
import com.time.album.timealbum.dto.resp.UserRespDto;

import java.util.List;

public interface AlbumService {
    /**
     * 获取相册列表
     * @param userId
     * @return
     */
    List<AlbumRespDto> listAlbum(Integer userId);

    /**
     * 获取相册用户
     * @param albumId
     * @return
     */
    List<UserRespDto> listUserByAlbumId(Integer albumId);
}
