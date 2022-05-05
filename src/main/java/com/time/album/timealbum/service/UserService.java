package com.time.album.timealbum.service;

import com.time.album.timealbum.dto.req.UserReqDto;
import com.time.album.timealbum.dto.resp.UserRespDto;
import com.time.album.timealbum.entity.User;
import com.time.album.timealbum.exception.BusinessException;

public interface UserService {
    /**
     * 根据用户Id获取用户
     * @param userId
     * @return
     */
    User getUserByUserId(Integer userId);

    /**
     * 用户登录
     * @param userReqDto
     * @return
     */
    UserRespDto userLogin(UserReqDto userReqDto) throws BusinessException;
}
