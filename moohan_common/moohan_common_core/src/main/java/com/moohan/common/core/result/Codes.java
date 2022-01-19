package com.moohan.common.core.result;

/**
 * 响应码枚举类
 */
public enum Codes {

    SUCCESS(200, "success"),
    RESOURCES_NOT_FOUND(404, "资源未找到"),
    PARAMS_ERROR(400, "字段校验未通过"),
    SERVER_EXCEPTION(500, "服务器异常，请稍后重试");

    public Integer code;
    public String msg;

    Codes(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
