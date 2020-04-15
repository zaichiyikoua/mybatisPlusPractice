package com.zaichiyikou.starter.handler;

import java.util.Date;

import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

// 一定要加入到IOC容器中
@Component
// handler处理器，处理注解，配合注解一起使用
public class MyMetaHandler implements MetaObjectHandler{

    
    private static final Logger log = LoggerFactory.getLogger(MyMetaHandler.class);

    // 这两个都是配合 @TableField(fill = )使用的，运行时利用反射机制去实现自动填充
    // 并且这个是很智能的，时间格式都会帮我们做好
    // 插入时的填充策略
    @Override
    public void insertFill(MetaObject metaObject) {
        // TODO Auto-generated method stub
        log.info("start insert fill");
        // 设置字段的值               字段名     字段值     
        this.setFieldValByName("createtime", new Date(), metaObject);
    }

    // 更新时的填充策略
    @Override
    public void updateFill(MetaObject metaObject) {
        // TODO Auto-generated method stub
        log.info("start update fill");
        // 设置字段的值               字段名     字段值     
        this.setFieldValByName("createtime", new Date(), metaObject);
    }

}
