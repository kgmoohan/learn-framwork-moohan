package com.moohan.common.core.utils;

import com.moohan.common.core.result.Codes;
import com.moohan.common.core.result.R;

/**
 * 快速构建R对象工具类
 */
public class RUtils {

    /**
     * 构造一个成功的R对象
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> R createSucc(T data) {
        return new R(Codes.SUCCESS.code, Codes.SUCCESS.msg, data);
    }

    /**
     * 构造一个失败的R对象
     *
     * @param code
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> R createFail(Integer code, String msg) {
        return new R(code, msg, null);
    }

    public static <T> R createFail(Codes codes) {
        return new R(codes.code, codes.msg, null);
    }

    public static <T> R createFail(Codes codes, T data) {
        return new R(codes.code, codes.msg, data);
    }

    /**
     * 构建一个常规的R对象
     *
     * @param code
     * @param msg
     * @param data
     * @param <T>
     * @return
     */
    public static <T> R create(Integer code, String msg, T data) {
        return new R(code, msg, data);
    }
}
