package com.moohan.common.web.valid.constraint;

import com.moohan.common.web.utils.ApplicationContextUtils;
import com.moohan.common.web.valid.annotation.MoohanValid;
import com.moohan.common.web.valid.handler.MoohanValidHandler;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

/**
 * 自定义的参数校验类
 */
public class MoohanValidConstraint implements ConstraintValidator<MoohanValid, Object> {

    private MoohanValid moohanValid;

    @Override
    public void initialize(MoohanValid moohanValid) {
        this.moohanValid = moohanValid;
    }

    /**
     * 校验具体方法
     *
     * @param value
     * @param context
     * @return true：通过；false：未通过。
     */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value != null) {
            Class<? extends MoohanValidHandler> handler = moohanValid.handler();
            //交给MoohanValidHandler处理该数据
            MoohanValidHandler moohanValidHandler = ApplicationContextUtils.getBean(handler);
            return Optional
                    .ofNullable(moohanValidHandler)
                    .map(moohanValidHandler1 -> {
                        return moohanValidHandler.valid(moohanValid, value);
                    }).orElse(false);
        }
        //由NotNull校验非空处理，直接通过校验
        return true;
    }
}
