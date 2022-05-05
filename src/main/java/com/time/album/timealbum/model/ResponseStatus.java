package com.time.album.timealbum.model;

/**
 * 响应状态
 * @author ~
 * @date 2022/04/11 16:14
 */
public interface ResponseStatus {

    /**
     * 获取响应码
     * @author ~
     * @date 2022/04/11 16:14
     */
    String getCode();

    /**
     * 获取响应消息
     * @author ~
     * @date 2022/04/11 16:14
     */
    String getMessage();
}
