# a shoppingcart in springboot
bootstrap
spring-boot,
SSM,
springMVC,
RESTful
mybatis,
JUnit
maven,
git

activemq P2P, topic
redis

spring boot & mybatis config:
    pom.xml:Add mybatis-spring-boot-starter, mysql-connector-java

    schema A:
        1.Add @Mapper in IUserMapper
        2.write sql in IUserMapper

    schema B:
        1.application.properties
            mybatis.configLocation=classpath:mybatis-config.xml
            mybatis.mapper-locations=classpath:persistence.mapper/*.xml
        2.Add @MapperScan("com.adaweng.boot.persistence.mapper") in UserController
        3.write sql in UserMapper.xml



