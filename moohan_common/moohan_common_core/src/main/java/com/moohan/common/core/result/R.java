package com.moohan.common.core.result;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 微服务 统一返回对象
 */
@Data
@Accessors(chain = true)
public class R<T> implements Serializable {

    /**
     * 响应码
     */
    private Integer code;

    /**
     * 响应结果
     */
    private String msg;

    /**
     * 数据部分
     */
    private T data;

    /**
     * 构造方法
     *
     * @param code
     * @param msg
     * @param data
     */
    public R(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
