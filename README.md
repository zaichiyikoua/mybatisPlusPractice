#### mybatisPlus工具的体验和练习

2020-4-13 笔记

1.使用mybatisPlus可以节省大量的时间和精力，但是要注意不要同时导入mybatis和mybatisPlus，可能存在冲突

2.配置数据库连接信息

3.原来的流程  pojo-dao(接口 xml 容易出错)-service-controller

4.使用mybatisPlus之后  pojo-mapper-使用

5.mybatisPlus可以配合日志输出  以后的学习既可以查看日志

mybatis-plus:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl

6.插入测试的结果表示  mybaitsPlus会自动生成ID。但是自动生成的ID可能并不是我们需要的。

2020-4-15 笔记

##### 1.update会通过条件自动动态的拼接sql(mybatisPlus及其重要的优势)

##### 2.自动填充，比如创建时间，修改时间等等，像这样的字段一般都是数据库自动完成的，不需要手动更新，也希望手动改。

2.1 数据库级别(但是在实际工作中是不允许去动数据库的，不要再new date然后去格式化再插入了)

2.1.1 在表中新增字段create_time，update_time

2.2 代码级别

2.2.1 删除数据库中默认值和更新操作

2.2.2 在实体类上增加注解(推荐使用)，然后去写一个注解handler类，实现metaobjecthandler接口，重写里面的两个方法

##### 3.MybatisPlus乐观锁机制
乐观锁一般使用version字段来实现，每次更新的时候去携带一个版本号来判断数据到底有没有更新

实现方式：

1.取出记录时，获取当前version

2.更新时，带上这个version

3.执行更新时，set version  = newVersion where version = oldVersion

4.如果version不对，则更新失败

举个栗子：

--A 线程
update user set name ="test",version = version + 1
where id = 2 and version = 1

--B 线程抢先执行，所以这个时候version = 2，那么线程A很明显就执行失败了，这就实现了数据的锁定机制

update user set name ="test",version = version + 1
where id = 2 and version = 1

##### 3.1MybatisPlus乐观锁的具体使用：
1.数据库增加version字段(这个肯定是必须的)

2.pojo实体类增加对应的字段

3.注解组件，增加配置类

##### 4.mybatisPlus的内置分页插件
流程：

1.配置拦截器组件(官方直接拿过来)

2.直接使用page对象即可

##### 5.逻辑删除
物理删除：从数据库中直接删除

逻辑删除：在数据库没有被删除，而是通过一个变量让它失效，应用场景比如，管理员可以查看被删除的数据，防止数据丢失，类似回收站的作用

流程：

1.在数据库中增加delete字段

2.增加pojo字段对应的注解

3.注册组件

##### 6.自动代码生成器

6.1 加入依赖配置，注意要加入模板velocity-engine-core，不然会报NoClassDefFoundError，视频上没讲，找了好久才解决这个问题

6.2 从官网上抄一份配置类下来，自己按需要进行修改，设定每个部分

6.3 启动该类 完成自动生成操作