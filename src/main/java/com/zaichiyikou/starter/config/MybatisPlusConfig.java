package com.zaichiyikou.starter.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;

@Configuration
// 注意 配置好了mapper之后要配置扫描
@MapperScan(basePackages = "com.zaichiyikou.starter.mapper")
@EnableTransactionManagement
public class MybatisPlusConfig {
    
    // 注册乐观锁插件
    @Bean
    // 这其实是一个拦截器
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
        
    }
}
