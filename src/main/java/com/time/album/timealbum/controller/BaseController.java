package com.time.album.timealbum.controller;

import com.time.album.timealbum.model.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controller基类
 * @author ~
 * @date 2022/04/11 16:14
 */
@Slf4j
public class BaseController {

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;

    /**
     * 全局异常处理
     * @param e
     * @return
     * @author ~
     * @date 2022/04/11 16:14
     */
    @ExceptionHandler(Exception.class)
    public ApiResponse exceptionHandler(Exception e) {
        log.error(e.getMessage(), e);
        return ApiResponse.failed(e.getMessage());
    }

}
