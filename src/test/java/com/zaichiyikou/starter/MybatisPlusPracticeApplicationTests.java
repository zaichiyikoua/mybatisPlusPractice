package com.zaichiyikou.starter;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    // 乐观锁测试 单线程下
    @Test
    void optimisticLockerTest() {
        // 1.查询用户信息
        SysRole role = roleMapper.selectById(1);
        // 2.修改用户信息
        role.setName("乐观锁");
        role.setRemark("乐观锁测试");
        // 3.执行更新操作
        roleMapper.update(role, null);
    }

    // MP查询测试
    @Test
    void selectTest() {
        // 多表查还是要自己写xml
        // 这种的是较为简单一点的单表条件查询，复杂的查询会使用到Wrapper
        // 多条件查询 KV 会实现自动拼接 这样更加方便，不用再去辛苦的写sql
        HashMap<String, Object> map = new HashMap<>();
        // KV会拼接成 where name = ?
        map.put("name", "...");
        map.put("remark", "...");
        // 很明显的需要一个map
        roleMapper.selectByMap(map);
    }

    // 分页查询测试
    @Test
    void pageTest() {
        // 注册完之后
        // 注意是mybatisPlus的page对象
        // 第一个参数是当前页 第二个参数是页面大小
        Page<SysRole> page = new Page<>(0, 5);
        // mybatisPlus的部分查询就是分页查询，需要page对象
        IPage<SysRole> selectPage = roleMapper.selectPage(page, null);

        page.getRecords().forEach(System.out::println);
        System.out.println(page.getTotal());
    }
    
    @Test
    void deleteTest() {
//        // 条件删除
//        roleMapper.delete(queryWrapper);
//        // 通过id批量删除 参数是Collection
//        roleMapper.deleteBatchIds(idList);
//        // 通过id删除
//        roleMapper.deleteById(id);
//        // 条件删除
//        roleMapper.deleteByMap(columnMap);
    }
}
