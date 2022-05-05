package com.time.album.timealbum.service.impl;

import com.time.album.timealbum.entity.User;
import com.time.album.timealbum.mapper.UserMapper;
import com.time.album.timealbum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 何巧莹
 * @ClassName UserServiceImpl
 * @Description
 * @since 2022/5/5
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 根据用户Id获取用户
     *
     * @param userId
     * @return
     */
    @Override
    public User getUserByUserId(Integer userId) {
        return userMapper.selectById(userId);
    }
}
