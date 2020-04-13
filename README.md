#### mybatisPlus工具的体验和练习

1.使用mybatisPlus可以节省大量的时间和精力，但是要注意不要同时导入mybatis和mybatisPlus，可能存在冲突

2.配置数据库连接信息

3.原来的流程  pojo-dao(接口 xml 容易出错)-service-controller

4.使用mybatisPlus之后  pojo-mapper-使用

5.mybatisPlus可以配合日志输出  以后的学习既可以查看日志

mybatis-plus:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl