package com.time.album.timealbum.controller;

import com.time.album.timealbum.dto.req.UserReqDto;
import com.time.album.timealbum.dto.resp.UserRespDto;
import com.time.album.timealbum.exception.BusinessException;
import com.time.album.timealbum.model.ApiResponse;
import com.time.album.timealbum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

/**
 * @author 何巧莹
 * @ClassName UserController
 * @Description 用户接口类
 * @since 2022/5/5 10:24
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/saveUser")
    @ResponseBody
    public ApiResponse saveUser(){
        return ApiResponse.success("hello");
    }

    @PostMapping("/userLogin")
    @ResponseBody
    public ApiResponse userLogin() throws BusinessException {
        UserReqDto userReqDto = new UserReqDto();
        userReqDto.setAccount("tom");
        userReqDto.setPassword("123");
        UserRespDto userRespDto = userService.userLogin(userReqDto);
        return ApiResponse.success(userRespDto);
    }
}
