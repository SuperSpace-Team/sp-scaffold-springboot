# 多模块Springboot脚手架
> 文档中心
#### 总体研发规范
    http://public-service.confluence.gw.yonghui.cn/pages/viewpage.action?pageId=34843178

#### API接口定义格式规范
    http://public-service.confluence.gw.yonghui.cn/pages/viewpage.action?pageId=32387316

####    公共规范包：
```
        <!--公共API开发规范包依赖-->
        <dependency>
            <groupId>com.yh.infra.common</groupId>
            <artifactId>yh-infra-common-lib</artifactId>
        </dependency>
        
        <!--公共Web项目规范包依赖-->
        <dependency>
            <groupId>com.yh.infra.common</groupId>
            <artifactId>yh-infra-common-web</artifactId>
        </dependency>
```

#### 代码生成器
    使用文档：http://public-service.confluence.gw.yonghui.cn/pages/viewpage.action?pageId=32393204
    代码仓库：http://gitlab.yonghui.cn/operation-cp-gggit/yh-common-lark-generator.git
> Swagger-ui

    http://localhost:8100/swagger-ui.html

> SQL监控

    默认禁用，如需开启请设置 enabled: true
    http://localhost:8100/druid/index.html

> 健康检查

    http://localhost:8100/actuator/health

## 工程结构(多模块详细包)说明

    {{service.code.lower}}-parent      服务名称,格式：yh-项目名-服务名
    │
    └─{{package}}.api               包命名：com.yonghui.服务名.api,微服务对外暴露的接口和域传输对象定义等,调用方依赖此包、功能酌情使用 
    │  ├─rest                       对外暴露的接口(调用方定义FeignClient类实现接口即可)
    │  ├─domain                     域传输对象定义
    │  │ │─vo                       视图对象(前端交互时使用)
    │  │ └─dto                      数据传输对象(服务间调用时使用)
    │  ├─annotation                 注解【非必须】
    │  ├─enums                      枚举【非必须】
    │  ├─constant                   常量【非必须】
    │  ├─exception                  异常【非必须】
    │  └─utils                      工具类【非必须】
    │
    └─{{package}}.server            包命名：com.yonghui.服务名.server,工程启动模块,包括Controller层定义、Web全局配置等
    │    ├─config                   Web全局配置
    │    │  └─SwaggerConfig.java    Swagger相关配置
    │    ├─controller               控制器定义(统一以@RestController声明)
    │    └─YhApp.java               服务启动类【类名可自定义】
    └─{{package}}.feign             包命名：com.yonghui.服务名.feign,调用其它服务的Feign接口定义模块
    │    ├─client                   FeignClient目标调用接口定义(@FeignClient注解中的name、value和url建议定义到配置文件中)
    │    │  └─[role]                子包目录,调用目标业务服务名称
    │    ├─fallback                 FeignClient的降级逻辑实现(建议返回自定义错误或固定的SystemErrorCodeEnum.BUSINESS_ERROR或SYSTEM_ERROR或SYSTEM_UNKNOWN_EXCEPTION提示信息)
    │    └─vo                       Feign调用使用的VO(视图对象)定义
    │
    └─{{package}}.service           包命名：com.yonghui.服务名.service,业务逻辑层,包括各业务Service接口定义和逻辑方法实现、BO(业务POJO类)定义等
    │    ├─base                     [推荐,非必须]
    │    │  ├─BaseBizService.java   基础业务Service接口定义(可酌情不使用)
    │    │  ├─BaseBizServiceImpl.java   基础业务实现类(可酌情不使用)
    │    ├─biz                      业务聚合类方法逻辑实现
    │    ├─bo                       BO(业务POJO类)
    │    ├─[user]                   子包目录,存放业务服务Service接口
    │    │  └─impl                  存放ServiceImpl实现类,业务Service接口方法逻辑实现
    │
    └─{{package}}.dao               包命名：com.yonghui.服务名.dao,数据持久层
    │    ├─aop                      业务聚合类方法逻辑实现
    │    ├─po                       PO(数据库实体POJO类)
    │    ├─mapper                   数据持久层Mapper接口定义(继承MP框架的BaseMapper<T>)
    │    ├─repo                     数据仓储层定义     
    │    │  ├─base                  存放公共仓储类
    │    │    ├─BaseBizRepository.java   公共仓储实现抽象类
    │    │  ├─[user]                存放业务仓储类(继承BaseBizRepository)【本文件初版代码可通过代码生成器生成】
    │    │    ├─[BizDemo1Dao].java          业务DAO实现类(可酌情不使用)
    │    │    ├─[BizDemo1Repository].java   业务仓储实现类(可酌情不使用)
    │     └──resources
    │       ├─mapper                *Mapper或*Dao接口对应的XML文件
    │       └─sql                   SQL脚本(初始化脚本,每次上线变更的SQL脚本等)
    └─
<br>

    资源列表
    └──resources
       ├─static                 静态资源
       ├─log4j2.xml             日志收集配置
       ├─bootstrap.yml          启动的基础配置(包含服务名、端口号以及配置中心的连接信息等)
       └─application.yml        应用要使用的配置信息、与环境相关的信息

<br>

## Apollo 配置中心

    http://public-service.itwork-book.gw.yonghui.cn/book/itwork/docs/qa/apollo.html

## 日志服务

    http://public-service.itwork-book.gw.yonghui.cn/book/itwork/docs/qa/elk.html

## 链路监控

    http://public-service.itwork-book.gw.yonghui.cn/book/itwork/docs/qa/skywalking.html

## CICD

    http://public-service.itwork-book.gw.yonghui.cn/book/itwork/docs/qa/cicd/cicd.html

## yh-infra-comp-*基础组件包 描述

* yh-infra-comp-feign               [Feign调用拦截 & OpenApi鉴权]
* yh-infra-comp-apollo              [Apollo定义]
* yh-infra-comp-datasource          [多数据源]
* yh-infra-comp-excel               [Excel操作工具集]
* yh-infra-comp-consul              [Consul公共client对象 & 配置项监听器]
* yh-infra-comp-logger              [日志收集 & 自定义Logger]
* yh-infra-comp-web-rest-registry   [REST API接口上报-SpringMVC]
* yh-infra-comp-sc-rest-registry    [REST API接口上报-SpringCloud]
* yh-infra-comp-geography           [第三方地图包操作工具集]
* yh-infra-comp-dubbo               [Dubbo异常拦截封装 & 拒绝策略封装]
* yh-infra-comp-elasticsearch       [ES操作工具集]
* yh-infra-comp-redis               [Redis操作工具集]

## 多数据源的配置

1. pom.xml引入 yh-infra-comp-datasource
2. application.yml 配置添加如下配置：

<br>

```yaml
spring:
  datasource:
    master:
      driverClassName: com.mysql.jdbc.Driver
      druid:
        filters: stat
        initialSize: 10
        maxActive: 20
        maxOpenPreparedStatements: 20
        maxWait: 60000
        minEvictableIdleTimeMillis: 300000
        minIdle: 1
        poolPreparedStatements: true
        testOnBorrow: true
        testOnReturn: false
        testWhileIdle: true
        timeBetweenEvictionRunsMillis: 60000
        validationQuery: SELECT 1
      password: Ho5E9G3p96bo
      type: com.alibaba.druid.pool.DruidDataSource
      url: jdbc:mysql://10.19.187.125:3306/employee_center?autoReconnect=true&zeroDateTimeBehavior=convertToNull&useUnicode=true&allowMultiQueries=true&characterEncoding=utf-8
      username: yhhy_stage
    slave:
      driverClassName: com.mysql.jdbc.Driver
      filters: stat
      initialSize: 10
      maxActive: 20
      maxOpenPreparedStatements: 20
      maxWait: 60000
      minEvictableIdleTimeMillis: 300000
      minIdle: 1
      password: Ho5E9G3p96bo
      poolPreparedStatements: true
      testOnBorrow: true
      testOnReturn: false
      testWhileIdle: true
      timeBetweenEvictionRunsMillis: 60000
      type: com.alibaba.druid.pool.DruidDataSource
      url: jdbc:mysql://10.19.187.125:3306/employee_center?autoReconnect=true&zeroDateTimeBehavior=convertToNull&useUnicode=true&allowMultiQueries=true&characterEncoding=utf-8
      username: yhhy_stage
      validationQuery: SELECT 1

```

## 数据库建表示例

    CREATE TABLE `sf_comp_info` (
    `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '组件记录ID',
    `version` bigint DEFAULT NULL COMMENT '锁标识',
    `comp_type_id` int DEFAULT NULL COMMENT '组件类型记录ID',
    `comp_type_code` varchar(50) DEFAULT NULL COMMENT '组件类型编码',
    `comp_code` varchar(200) DEFAULT NULL COMMENT '组件编码',
    `comp_name` varchar(200) DEFAULT NULL COMMENT '组件名称',
    `description` varchar(1000) DEFAULT NULL COMMENT '组件描述信息',
    `is_delete` bit(1) DEFAULT b'0' COMMENT '是否有效(0:未删除的有效记录,1:逻辑删除的无效记录)',
    `created_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
    `created_at` date DEFAULT NULL COMMENT '创建时间',
    `updated_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
    `updated_at` date DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

#### 一般来说，id,version,is_delete,created_by,created_at,updated_by,updated_at这些为公共字段，对应BasePO、定义数据库实体类的时候可以继承。

## 开发规范
### 分层领域模型规约：

    * PO（ORM Entity Object）：持久化实体，与数据库表结构一一对应，通过 DAO 层向上传输数据源对象。
    * DTO（Data Transfer Object）：数据传输对象，Service 和 Manager 向外传输的对象，或Feign/RPC服务间调用时使用。
    * BO（Business Object）：业务对象。可以由 Service 层输出的封装业务逻辑的对象。
    * Query：数据查询对象，各层接收上层的查询请求。注：超过 2 个参数的查询封装，禁止使用 Map 类来传输。
    * VO（View Object）：显示层对象，通常是 Web 向模板渲染引擎层传输的对象。 

### 安全规约

【强制】用户请求传入的任何参数必须做有效性验证。

    说明：忽略参数校验可能导致：
    * page size 过大导致内存溢出
    * 恶意 order by 导致数据库慢查询
    * 任意重定向
    * SQL 注入
    * 反序列化注入
    * 正则输入源串拒绝服务 ReDoS
    说明：Java 代码用正则来验证客户端的输入，有些正则写法验证普通用户输入没有问题，
    但是如果攻击人员使用的是特殊构造的字符串来验证，有可能导致死循环的结果。

防重放限制

    在使用平台资源，譬如短信、邮件、电话、下单、支付，必须实现正确的防重放限制，
    如数量限制、疲劳度控制、验证码校验，避免被滥刷、资损。
    说明：如注册时发送验证码到手机，如果没有限制次数和频率，那么可以利用此功能骚扰到其
    它用户，并造成短信平台资源浪费。



