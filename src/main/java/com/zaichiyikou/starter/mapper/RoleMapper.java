package com.zaichiyikou.starter.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zaichiyikou.starter.pojo.SysRole;

@Mapper
// 使用了mybatis之后，基本的crud不用写了，继承BaseMapper即可
// 可以不再写一大堆的配置文件
// 注意泛型，想操作什么就操作什么
// 但是基本上配置的都是单表查询，复杂的查询还是要自己写
public interface RoleMapper extends BaseMapper<SysRole>{
    // basemapper父类中有很多Wrapper
    // 这是一个条件构造器
}
