package com.time.album.timealbum.exception;

import com.time.album.timealbum.enums.UserStateCode;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 业务异常
 * @author ~
 * @date 2022/04/11 16:14
 */
@Data
@AllArgsConstructor
public class BusinessException extends Exception {
    private String message;

    public BusinessException(UserStateCode userStateCode){
        super(userStateCode.getMsg());
        this.message = userStateCode.getMsg();
    }
}
