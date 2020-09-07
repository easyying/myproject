package com.daguo.comp;

/**
 * 状态枚举
 */
public enum StatusCodeEnum {
    SUCCESS("200","成功"),

    PARAMS_ERROR("400","参数错误"),

    CLIENT_ERROR("401","无业务权限"),

    SERVER_ERROR("500","服务器内部错误"),

    // 网关层统一用 1000 开头
    SIGN_FAIL("1000" , "验证签名失败"),

    APP_KEY_INVAID("1001" , "APP_KEY无效");


    private String code;

    private String msg;

    StatusCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
