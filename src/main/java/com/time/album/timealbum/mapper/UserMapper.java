package com.time.album.timealbum.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.time.album.timealbum.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {
    User getUserByUserId(@Param("userId") Integer userId);
}
