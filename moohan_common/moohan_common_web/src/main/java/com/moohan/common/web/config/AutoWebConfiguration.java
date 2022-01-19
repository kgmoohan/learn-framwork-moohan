package com.moohan.common.web.config;

import com.moohan.common.web.exception.GlobalException;
import com.moohan.common.web.utils.ApplicationContextUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Web自动装配统一，SpringBoot自动装配实现
 * SpringBoot= SpringIOC+自动装配
 */
@Configuration
@ComponentScan("com.moohan.business")
public class AutoWebConfiguration {

    /**
     * 配置全局异常处理器
     *
     * @return
     */
    @Bean
    public GlobalException getGlobalException() {
        return new GlobalException();
    }

    /**
     * spring容器的工具类
     *
     * @return
     */
    @Bean
    public ApplicationContextUtils getApplicationContextUtils() {
        return new ApplicationContextUtils();
    }
}
