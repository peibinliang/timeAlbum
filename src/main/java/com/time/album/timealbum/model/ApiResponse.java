package com.time.album.timealbum.model;

import com.time.album.timealbum.constants.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author 何巧莹
 * @ClassName ApiResponse
 * @Description
 * @since 2022/5/5
 */
@Data
@ToString
@AllArgsConstructor
public class ApiResponse<T> {
    private String code;

    private String message;

    private T data;

    /**
     * 成功
     * @author ~
     * @date 2022/04/11 16:14
     */
    public static <T> ApiResponse<T> success(ResponseStatus status, T data) {
        return new ApiResponse(status.getCode(), status.getMessage(), data);
    }

    /**
     * 成功
     * @author ~
     * @date 2022/04/11 16:14
     */
    public static <T> ApiResponse<T> success(T data) {
        return success(Constants.ResponseStatus.SUCCESS, data);
    }

    /**
     * 成功
     * @author ~
     * @date 2022/04/11 16:14
     */
    public static <T> ApiResponse<T> success() {
        return success(null);
    }

    /**
     * 失败
     * @author ~
     * @date 2022/04/11 16:14
     */
    public static <T> ApiResponse<T> failed(String message) {
        return new ApiResponse(Constants.ResponseStatus.FAILED.getCode(), message, null);
    }

    /**
     * 失败
     * @author ~
     * @date 2022/04/11 16:14
     */
    public static <T> ApiResponse<T> failed(ResponseStatus status) {
        return new ApiResponse(status.getCode(), status.getMessage(), null);
    }

    /**
     * 失败
     * @author ~
     * @date 2022/04/11 16:14
     */
    public static <T> ApiResponse<T> failed(RemoteResponse remoteResponse) {
        return new ApiResponse(remoteResponse.getCode(), remoteResponse.getMessage(), null);
    }
}
