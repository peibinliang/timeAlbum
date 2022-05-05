package com.time.album.timealbum.model;

import com.time.album.timealbum.constants.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author 何巧莹
 * @ClassName RemoteResponse
 * @Description
 * @since 2022/5/5
 */
@Data
@ToString
@AllArgsConstructor
public class RemoteResponse<T> implements Serializable {
    private String code;

    private String message;

    private T data;

    /**
     * 判断请求是否成功
     * @author ~
     * @date 2022/04/11 16:14
     */
    public Boolean isSuccess() {
        return this.getCode().equals(Constants.ResponseStatus.SUCCESS.getCode());
    }

    /**
     * 成功
     * @author ~
     * @date 2022/04/11 16:14
     */
    public static <T> RemoteResponse<T> success(ResponseStatus status, T data) {
        return new RemoteResponse(status.getCode(), status.getMessage(), data);
    }

    /**
     * 成功
     * @author ~
     * @date 2022/04/11 16:14
     */
    public static <T> RemoteResponse<T> success(T data) {
        return success(Constants.ResponseStatus.SUCCESS, data);
    }

    /**
     * 成功
     * @author ~
     * @date 2022/04/11 16:14
     */
    public static <T> RemoteResponse<T> success() {
        return success(null);
    }

    /**
     * 失败
     * @author ~
     * @date 2022/04/11 16:14
     */
    public static <T> RemoteResponse<T> failed(String message) {
        return new RemoteResponse(Constants.ResponseStatus.FAILED.getCode(), message, null);
    }

    /**
     * 失败
     * @author ~
     * @date 2022/04/11 16:14
     */
    public static <T> RemoteResponse<T> failed(ResponseStatus status) {
        return new RemoteResponse(status.getCode(), status.getMessage(), null);
    }
}
