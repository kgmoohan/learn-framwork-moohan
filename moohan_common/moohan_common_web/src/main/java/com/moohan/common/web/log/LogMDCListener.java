package com.moohan.common.web.log;

import org.slf4j.MDC;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.GenericApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

/**
 * springBoot事件的监听器
 */
public class LogMDCListener implements GenericApplicationListener {

    private final static String CONFIG_PROPERTIES = "configurationProperties";
    private final static String APP_NAME = "spring.application.name";
    private final static String LOG4J2_NAME = "logName";

    /**
     * 设置当前监听什么类型的事件
     * --指定ApplicationEnvironmentPreparedEvent 环境准备事件
     *
     * @param resolvableType
     * @return
     */
    @Override
    public boolean supportsEventType(ResolvableType resolvableType) {
        // A.class.isAssignableFrom(B.class)
        // 若A类型是B类型的父类（接口、同一个类型），则返回true
        return ApplicationEnvironmentPreparedEvent.class.isAssignableFrom(resolvableType.getRawClass());
    }

    /**
     * 监听到具体事件的处理方法
     *
     * @param applicationEvent
     */
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        ApplicationEnvironmentPreparedEvent event = (ApplicationEnvironmentPreparedEvent) applicationEvent;
        ConfigurableEnvironment environment = event.getEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();
        PropertySource<?> ps = propertySources.get(CONFIG_PROPERTIES);
        String appName = (String) ps.getProperty(APP_NAME);
        MDC.put(LOG4J2_NAME, appName);
        System.out.println("name=" + appName);
    }

    /**
     * 控制监听器的顺序，值越小优先级越高
     *
     * @return
     */
    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE+19;
    }
}
