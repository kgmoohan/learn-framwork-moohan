package com.moohan.common.web.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 自定义业务异常
 */
@Data
@AllArgsConstructor
public class ServiceException extends RuntimeException {

    private Integer code;

    private String msg;
}
