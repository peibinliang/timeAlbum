package com.time.album.timealbum.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.time.album.timealbum.dto.resp.UserRespDto;
import com.time.album.timealbum.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {
    /**
     * 获取用户
     * @param userId
     * @return
     */
    User getUserByUserId(@Param("userId") Integer userId);

    /**
     * 根据账号获取用户
     * @param account
     * @return
     */
    UserRespDto getUserByAccount(@Param("account") String account);

    /**
     * 根据用户名获取用户
     * @param userName
     * @return
     */
    UserRespDto getUserByUserName(@Param("userName") String userName);

    /**
     * 根据手机号获取用户
     * @param phone
     * @return
     */
    UserRespDto getUserByPhone(@Param("phone") String phone);
}
