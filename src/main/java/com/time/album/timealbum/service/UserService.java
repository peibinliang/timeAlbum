package com.time.album.timealbum.service;

import com.time.album.timealbum.entity.User;

public interface UserService {
    /**
     * 根据用户Id获取用户
     * @param userId
     * @return
     */
    User getUserByUserId(Integer userId);
}
