package com.zaichiyikou.starter.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

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
    
    // 注册分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        // 这种是基础配置，如果还要扩展，去官网看具体的配置
        // 不用再写limit了
        return new PaginationInterceptor();
    }
    
    // 注册逻辑删除组件
    @Bean
    public ISqlInjector isqlInjector() {
        return new LogicSqlInjector();
    }
}
