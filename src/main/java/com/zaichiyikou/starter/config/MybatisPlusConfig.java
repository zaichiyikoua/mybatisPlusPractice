package com.zaichiyikou.starter.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
// 注意 配置好了mapper之后要配置扫描
@MapperScan(basePackages = "com.zaichiyikou.starter.mapper")
@EnableTransactionManagement
public class MybatisPlusConfig {

}
