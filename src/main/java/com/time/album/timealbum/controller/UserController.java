package com.time.album.timealbum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 何巧莹
 * @ClassName UserController
 * @Description 用户接口类
 * @since 2022/5/5 10:24
 */
@Controller
public class UserController {

    @GetMapping("saveUser")
    @ResponseBody
    public String saveUser(){
        return "Hello,World!";
    }
}
