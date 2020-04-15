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

1.update会通过条件自动动态的拼接sql(mybatisPlus及其重要的优势)

2.自动填充，比如创建时间，修改时间等等，像这样的字段一般都是数据库自动完成的，不需要手动更新，也希望手动改。

2.1 数据库级别

2.1.1 在表中新增字段create_time，update_time