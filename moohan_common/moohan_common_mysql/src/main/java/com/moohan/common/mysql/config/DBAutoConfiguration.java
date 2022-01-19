package com.moohan.common.mysql.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan("com.moohan.data.mapper")
@EnableTransactionManagement
public class DBAutoConfiguration {
}
