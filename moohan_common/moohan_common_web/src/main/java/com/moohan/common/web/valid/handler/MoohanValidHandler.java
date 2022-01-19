package com.moohan.common.web.valid.handler;

import com.moohan.common.web.valid.annotation.MoohanValid;

/**
 * 拓展接口，让开发者实现该接口，拓展自定义的校验规则
 */
public interface MoohanValidHandler<T> {

    /**
     * 实际的校验发放
     *
     * @param data
     * @return
     */
    boolean valid(MoohanValid moohanValid, T data);
}
