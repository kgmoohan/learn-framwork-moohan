# learn-framwork-moohan
微服务高性能框架搭建

### 一、简介

> 项目是一款自己搭建的架构源码，基于当下很多流行的技术与框架，并结合自己多年开发的一些设计思想与理念构建，致力于打造一款可以用于高效开发的微服务架构，项目后续会不断进行更新迭代，优化调整添加其他的相关技术，并且整个架构的搭建过程后续会有配套的视频推出，关于项目有什么意见与建议，欢迎和本人沟通。

### 二、架构结构图

> **注意：图形为总体架构，部分技术栈当前版本并未整合，后续会陆续迭代更新**

![输入图片说明](http://assets.processon.com/chart_image/61357478f346fb07155fe593.png "架构结构图")

### 三、项目源码结构介绍

```html
live-platform  
│  ├─ agent -- skywalking链接探针                                                   
│  ├─ live-ability -- 公共服务模块                               
│  │  ├─ live-ability-auth -- 统一认证服务                                
│  │  ├─ live-ability-gateway -- 路由网关服务                                 
│  │  ├─ live-ability-search -- 分布式搜索服务                                           
│  │  ├─ live-ability-sentinel-server -- sentinel集群流控服务                                    
│  ├─ live-business -- 业务服务模块
│  │  ├─ 业务相关微服务工程
│  ├─ live-common -- 通用工具模块
│  │  ├─ live-common-auth -- security相关配置模块
│  │  ├─ live-common-cache -- 分布式多级缓存模块
│  │  ├─ live-common-core -- 架构基础模块
│  │  ├─ live-common-event -- 事件总线模块
│  │  ├─ live-common-mysql -- mysql数据库模块
│  │  ├─ live-common-redis -- redis功能模块
│  │  ├─ live-common-sentinel -- sentinel熔断限流模块
│  │  ├─ live-common-web -- web服务核心模块
│  ├─ live-config -- 统一配置管理（多环境配置）
│  ├─ live-data -- 基础数据模块
│  │  ├─ live-data-entity -- 实体类数据模块
│  │  ├─ live-data-mapper -- mybatis映射文件
```

### 四、项目配套视频

[https://www.bilibili.com/video/BV1hQ4y1z78B?spm_id_from=333.999.0.0](https://www.bilibili.com/video/BV1hQ4y1z78B?spm_id_from=333.999.0.0)

