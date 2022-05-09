package com.time.album.timealbum.service;

import com.time.album.timealbum.dto.req.UserReqDto;
import com.time.album.timealbum.dto.resp.UserRespDto;
import com.time.album.timealbum.exception.BusinessException;

public interface UserService {
    /**
     * 根据用户Id获取用户
     * @param userId
     * @return
     */
    UserRespDto getUserByUserId(Integer userId);

    /**
     * 用户登录
     * @param userReqDto
     * @return
     */
    UserRespDto userLogin(UserReqDto userReqDto) throws BusinessException;

    /**
     * 忘记密码
     * @param userReqDto
     * @return
     */
    boolean forgetPassword(UserReqDto userReqDto) throws BusinessException;

    /**
     * 新增用户
     * @param userReqDto
     * @return
     */
    boolean saveUser(UserReqDto userReqDto) throws BusinessException;

    /**
     * 编辑用户
     * @param userReqDto
     * @return
     */
    boolean modifyUser(UserReqDto userReqDto);
}
