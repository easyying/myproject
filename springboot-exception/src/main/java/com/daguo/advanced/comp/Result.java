package com.daguo.advanced.comp;

import lombok.Getter;
import lombok.Setter;

/**
 * Result对象包含协议属性：
 * success:是否成功  成功代表网关层、业务层都正常； 失败可能是网关层失败 或者 业务层失败，进一步判断code
 * data:消息体。 （正确信息使用）
 * code:状态码。    网关或者业务状态码，正常业务码返回默认200，业务失败比如：参数错误，内部错误等，网关验证失败比如：签名错误、APP-KEY无效等
 * msg:描述信息。
 */
@Setter
@Getter
public class Result<T> {
    private boolean success = false;//是否成功
    private String code;//状态码
    private String msg;//描述信息
    private T data;//消息体

    private Result() {

    }
    public Result(boolean success, T data, String code, String msg) {
        this.success = success;
        this.data = data;
        this.code = code;
        this.msg = msg;
    }
    /**
     * 得到异常Result
     *
     * @param code 用于设置Result.code字段
     * @param msg  用于设置Result.msg字段
     */
    public static <T> Result<T> getErrorResult(String code, String msg) {
        Result<T> result = new Result<T>();
        result.setSuccess(false);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
    /**
     * 得到正常Result
     *
     * @param data 消息体
     */
    public static <T> Result<T> getSuccessResult(T data) {
        Result<T> result = new Result<T>();
        result.setSuccess(true);
        result.setCode(StatusCodeEnum.SUCCESS.getCode());
        result.setData(data);
        return result;
    }

    public static <T> Result success() {
        return success(null);
    }

    public static <T> Result success(T result) {
        return success(StatusCodeEnum.SUCCESS.getMsg(), result);
    }

    public static <T> Result success(String msg, T result) {
        return new Result(true,result, StatusCodeEnum.SUCCESS.getCode(), msg);
    }
}
