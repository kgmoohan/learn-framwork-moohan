package com.moohan.common.web.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Spring容器的工具类方法，手动从Spring容器中获取Bean对象
 */
@Component
public class ApplicationContextUtils {

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * 静态容器对象
     */
    public static ApplicationContext staticApplicationContext;

    /**
     * 初始化方法
     */
    @PostConstruct
    public void init() {
        ApplicationContextUtils.staticApplicationContext = applicationContext;
    }

    /**
     * 根据class类型获取spring容器中的对象
     *
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> cls) {
        if (staticApplicationContext != null) {
            return staticApplicationContext.getBean(cls);
        }
        return null;
    }
}
