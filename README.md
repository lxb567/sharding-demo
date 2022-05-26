# sharding-demo
#分库分表示例
#sharding-jdbc + springboot + druid-starter + mybatis-plus
~~~~
版本信息
springboot2.6.3
shardingshpere/sharding-jdbc 5.0.0
druid-springboot starter 1.2.8
~~~~

1.使用druid starter需要在启动类排除druid的自动配置
~~~~
@SpringBootApplication(exclude = { DruidDataSourceAutoConfigure.class})
~~~~

2.使用druid jar包就直接使用
~~~~
@SpringBootApplication
~~~~

3.使用hikaricp则在application.properties打开注释，并去掉druid的配置，并且启动类去掉排除的代码和pom中的druid的依赖
~~~~
#spring.shardingsphere.datasource.m1.type=com.alibaba.druid.pool.DruidDataSource
spring.shardingsphere.datasource.m1.type=com.zaxxer.hikari.HikariDataSource
~~~~

4.测试类只有两个方法，此版本用于学习，分表，无分库，事物相关

5.实体类的cid没有添加@TableId所以test中id是直接设置的，如果加了id的注解，则会自动根据配置文件配置的id生成策略(snowflake)来生成id

6.sharding-jdbc最新版本5.1.0的目前简单的用hikaricp，如果使用druid会报错，如果druid可以使用，请不吝指教，扣扣：1003956514
