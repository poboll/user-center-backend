# 鱼皮用户中心的后端部分

## 项目简介
鱼皮用户中心的后端部分是一个基于Spring Boot的练手项目，旨在实现用户中心功能，包括用户管理的CRUD操作。

## 运行项目

### 克隆项目
```bash
git clone https://github.com/poboll/user-center-backend.git
```

### 建数据库表
请执行以下 SQL 文件以创建数据库表结构：[sql文件](res/sql/shema.sql)

### 修改配置信息
在运行项目之前，请根据以下步骤修改 `application.yml` 配置文件中的相关信息：

```properties
spring:
    application:
        name: user-center-backend
    datasource:
        driver-class-name: com.mysql.cj.jdbc.Driver
        url: jdbc:mysql://localhost:3306/user_center #数据库url
        username: <你的数据库用户名>
        password: <你的数据库密码>
    session:
        timeout: 86400
server:
    port: <运行端口>
    servlet:
        context-path: /api
mybatis-plus:
    mapper-locations: classpath*:mapper/*Mapper.xml
    configuration:
        map-underscore-to-camel-case: false
    global-config:
        db-config:
            logic-delete-field: isDelete
            logic-delete-value: 1
            logic-not-delete-value: 0
```

### 在IDEA中运行

### 使用Postman测试接口
你可以使用以下 Postman JSON 文件来测试接口：[json文件](res/poseman/鱼皮用户中心.postman_collection.json)
