package com.time.album.timealbum.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.time.album.timealbum.dto.req.UserReqDto;
import com.time.album.timealbum.dto.resp.UserRespDto;
import com.time.album.timealbum.entity.User;
import com.time.album.timealbum.enums.UserStateCode;
import com.time.album.timealbum.exception.BusinessException;
import com.time.album.timealbum.mapper.UserMapper;
import com.time.album.timealbum.service.UserService;
import com.time.album.timealbum.utils.Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author 何巧莹
 * @ClassName UserServiceImpl
 * @Description
 * @since 2022/5/5
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 根据用户Id获取用户
     *
     * @param userId
     * @return
     */
    @Override
    public UserRespDto getUserByUserId(Integer userId) {
        return BeanUtil.toBean(userMapper.selectById(userId),UserRespDto.class);
    }

    /**
     * 用户登录
     *
     * @param userReqDto
     * @return
     */
    @Override
    public UserRespDto userLogin(UserReqDto userReqDto) throws BusinessException {
        //通过账号获取用户
        UserRespDto userRespDto = userMapper.getUserByAccount(userReqDto.getAccount());
        if(Objects.isNull(userRespDto)){
            throw new BusinessException(UserStateCode.BU10002);
        }else if(!userReqDto.getPassword().equals(userRespDto.getPassword())){
            throw new BusinessException(UserStateCode.BU10003);
        }
        return userRespDto;
    }

    /**
     * 忘记密码
     *
     * @param userReqDto
     * @return
     */
    @Override
    public boolean forgetPassword(UserReqDto userReqDto) throws BusinessException {
        //验证手机号格式
        if (!Utils.CorrectPhoneNumber(userReqDto.getPhone())){
            throw new BusinessException(UserStateCode.BU10005);
        }
        //根据用户名获取用户
        UserRespDto user = userMapper.getUserByUserName(userReqDto.getUserName());
        if (Objects.isNull(user)){//用户不存在
            throw new BusinessException(UserStateCode.BU10002);
        }else if (!user.getPhone().equals(userReqDto.getPhone())){//手机号不正确
            throw new BusinessException(UserStateCode.BU10004);
        }
        user.setPassword(userReqDto.getPassword());
        return userMapper.updateById(BeanUtil.toBean(user,User.class))>0;//更新密码
    }

    /**
     * 新增用户
     *
     * @param userReqDto
     * @return
     */
    @Override
    public boolean saveUser(UserReqDto userReqDto) throws BusinessException {
        //验证手机号格式
        if (!Utils.CorrectPhoneNumber(userReqDto.getPhone())){
            throw new BusinessException(UserStateCode.BU10005);
        }
        //验证是否有重名用户
        if (Objects.nonNull(userMapper.getUserByUserName(userReqDto.getUserName()))){
            throw new BusinessException(UserStateCode.BU10001);
        }
        //验证手机号是否已注册使用
        if (Objects.nonNull(userMapper.getUserByPhone(userReqDto.getPhone()))){
            throw new BusinessException(UserStateCode.BU10008);
        }
        return userMapper.insert(BeanUtil.toBean(userReqDto,User.class))>0;
    }

    /**
     * 编辑用户
     *
     * @param userReqDto
     * @return
     */
    @Override
    public boolean modifyUser(UserReqDto userReqDto) {
        //根据用户ID更新用户信息
        return userMapper.updateById(BeanUtil.toBean(userReqDto,User.class))>0;
    }

    /**
     * 新增相册成员
     *
     * @param userReqDto
     * @return
     */
    @Override
    public boolean addMember(UserReqDto userReqDto) {
        //对象类型转换
        User user = BeanUtil.toBean(userReqDto, User.class);
        userMapper.insert(user);
        userMapper.saveUserRelation(userReqDto.getAlbumId(),user.getUserId());
        return false;
    }
}
