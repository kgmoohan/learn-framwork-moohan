package com.moohan.common.web.exception;

import com.moohan.common.core.result.Codes;
import com.moohan.common.core.result.R;
import com.moohan.common.core.utils.RUtils;
import com.moohan.common.web.utils.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * 全局异常捕获- 处理基于Controller抛出的异常
 */
@RestControllerAdvice
@Slf4j
public class GlobalException {

    /**
     * valid字段校验异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    public R bindExceptionHandler(BindException e) {
        log.error("[Bind-Exception] - 捕获到字段校验异常信息", e);
        //获得绑定返回对象
        BindingResult bindingResult = e.getBindingResult();
        //获得校验未通过的所有提示
        Set<String> errorSet = bindingResult.getAllErrors().stream().map(objectError
                -> objectError.getDefaultMessage()).collect(Collectors.toSet());
        return RUtils.createFail(Codes.PARAMS_ERROR, errorSet);
    }

    /**
     * spring自带字段校验异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public R illegalArgumentExceptionHandler(IllegalArgumentException e) {
        log.error("[Service-Exception] - 捕获到业务异常信息", e);
        return RUtils.createFail(Codes.SERVER_EXCEPTION.code, e.getMessage());
    }

    /**
     * 业务异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ServiceException.class)
    public R serviceExceptionHandler(ServiceException e) {
        log.error("[Service-Exception] - 捕获到业务异常信息", e);
        return RUtils.createFail(e.getCode(), e.getMsg());
    }

    /**
     * 默认异常处理
     *
     * @param t
     * @return
     */
    @ExceptionHandler
    public R globalExceptionHandler(Throwable t) {
        log.error("[Global-Exception] - 捕获到全局异常信息");
        String url = HttpUtils.getRequest().toString();
        log.error("[Global-Exception] - 当前请求URL={}", url);
        log.error("[Global-Exception] - 异常信息", t);
        return RUtils.createFail(Codes.SERVER_EXCEPTION);
    }
}
