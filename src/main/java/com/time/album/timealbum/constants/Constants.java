package com.time.album.timealbum.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 系统常量
 * @author ~
 * @date 2022/04/11 16:14
 */
public interface Constants {

    /**
     * 通用的响应状态定义
     * @author ~
     * @date 2022/04/11 16:14
     */
    @Getter
    @AllArgsConstructor
    enum ResponseStatus implements com.time.album.timealbum.model.ResponseStatus {
        SUCCESS("SUCCESS", "请求成功"),
        FAILED("FAILED", "请求失败"),
        ;
        private String code;

        private String message;
    }

}
