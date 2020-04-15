package com.zaichiyikou.starter;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.zaichiyikou.starter.mapper.RoleMapper;
import com.zaichiyikou.starter.pojo.SysRole;

@SpringBootTest
class MybatisPlusPracticeApplicationTests {

    // 继承了basemapper 方法都来自父类
    @Autowired
    private RoleMapper roleMapper;

    @Test
    void contextLoads() {
        // basemapper父类中有很多Wrapper，这是条件构造器，如果为null就是没有条件
        // 下面这个例子 就是直接查出全部的role
        List<SysRole> list = roleMapper.selectList(null);
        for (SysRole role : list) {
            System.out.println(role);
        }
        SysRole selectById = roleMapper.selectById(4);
        System.out.println(selectById);
    }

    // 插入测试
//    @Test
//    void insertTest() {
//        SysRole role = new SysRole();
//        role.setName("插入测试");
//        role.setRemark("charuceshi");
//        role.setAvailable(null);
//        
//        int result = roleMapper.insert(role);
//        System.out.println(">>>>>>");
//        System.out.println(result);
//        System.out.println(role);
//
//    }
    void updateTest() {
        SysRole role = new SysRole();
        role.setName("更新测试");
        role.setRemark("charuceshi");
        role.setAvailable(null);

        // 这个update也是有updateWrapper条件构造器的
//          roleMapper.update(entity, updateWrapper)
        int i = roleMapper.updateById(role);
        System.out.println(i);
    }
}
