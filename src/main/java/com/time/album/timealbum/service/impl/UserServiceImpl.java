package com.time.album.timealbum.service.impl;

import com.time.album.timealbum.dto.req.UserReqDto;
import com.time.album.timealbum.dto.resp.UserRespDto;
import com.time.album.timealbum.entity.User;
import com.time.album.timealbum.enums.UserStateCode;
import com.time.album.timealbum.exception.BusinessException;
import com.time.album.timealbum.mapper.UserMapper;
import com.time.album.timealbum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

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

    /**
     * 用户登录
     *
     * @param userReqDto
     * @return
     */
    @Override
    public UserRespDto userLogin(UserReqDto userReqDto) throws BusinessException {
        UserRespDto userRespDto = userMapper.getUserByAccount(userReqDto.getAccount());
        if(Objects.isNull(userRespDto)){
            throw new BusinessException(UserStateCode.BU10002);
        }else if(!userReqDto.getPassword().equals(userRespDto.getPassword())){
            throw new BusinessException(UserStateCode.BU10003);
        }
        return userRespDto;
    }
}
