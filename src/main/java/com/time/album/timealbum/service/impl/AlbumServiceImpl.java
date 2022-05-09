package com.time.album.timealbum.service.impl;

import com.time.album.timealbum.dto.resp.AlbumRespDto;
import com.time.album.timealbum.dto.resp.UserRespDto;
import com.time.album.timealbum.mapper.AlbumMapper;
import com.time.album.timealbum.service.AlbumService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 何巧莹
 * @ClassName AlbumServiceImpl
 * @Description
 * @since 2022/5/8
 */
@Service
public class AlbumServiceImpl implements AlbumService {
    @Resource
    private AlbumMapper albumMapper;

    /**
     * 获取相册列表
     *
     * @param userId
     * @return
     */
    @Override
    public List<AlbumRespDto> listAlbum(Integer userId) {
        return albumMapper.lsitAlbum(userId);
    }

    /**
     * 获取相册用户
     *
     * @param albumId
     * @return
     */
    @Override
    public List<UserRespDto> listUserByAlbumId(Integer albumId) {
        return albumMapper.listUserByAlbumId(albumId);
    }
}
