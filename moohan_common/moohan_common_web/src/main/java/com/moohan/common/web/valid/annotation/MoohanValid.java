package com.moohan.common.web.valid.annotation;

import com.moohan.common.web.valid.constraint.MoohanValidConstraint;
import com.moohan.common.web.valid.handler.MoohanValidHandler;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义的参数校验注解
 * target和retention是必须传入的
 * constraint：当前自定义的参数校验注解，对应的校验类型
 */
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MoohanValidConstraint.class)
public @interface MoohanValid {

    /**
     * 校验失败后提示
     *
     * @return
     */
    String message() default "校验失败";

    /**
     * 校验的分组
     *
     * @return
     */
    Class<?>[] groups() default {};

    /**
     * 校验的负载
     *
     * @return
     */
    Class<? extends Payload>[] payload() default {};

    /**
     * 实际校验处理器的Class对象
     *
     * @return
     */
    Class<? extends MoohanValidHandler> handler();
}
