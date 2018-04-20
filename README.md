# a shoppingcart in springboot/Java

1 Access url
	http://localhost:8080/shoppingcart/products
	http://localhost:8080/shoppingcart/myShoppingCart
	
2 Technology stack
	bootstrap
	spring-boot,
	SSM,
	springMVC,
	RESTful
	mybatis,
	JUnit
	maven,
	git

3 Design pattern
	strategy pattern
	singleton pattern
	responsibility chain
	
4 OOD & DDD & TDD
	service parameter encapsulation
	compatibility
	extensibility
	single responsibility chain
	processor
	high cohesion and low coupling
	modularization
	interface design
	domain object

5 ORM & DAO
	Transactional
	mybatis association mapping
	database & table design
	
6 lamda filter stream

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



