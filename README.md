# HiddenPoint Project

## 项目简介

HiddenPoint 是一个埋点管理平台，旨在帮助开发者和分析师管理和监控应用中的埋点事件。该平台支持创建、更新、删除和查看各种埋点数据，如项目、页面、模块、事件、参数和资源关系。

## 功能描述

- **项目管理**: 创建、更新、删除和查看项目。
- **页面管理**: 创建、更新、删除和查看页面。
- **模块管理**: 创建、更新、删除和查看模块。
- **事件管理**: 创建、更新、删除和查看事件。
- **参数管理**: 创建、更新、删除和查看参数。
- **页面模块关系管理**: 创建、更新、删除和查看页面和模块之间的关系。
- **项目资源管理**: 创建、更新、删除和查看项目资源。

## 安装和运行指南

### 先决条件

- [Java JDK 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org/install.html)
- [MySQL](https://dev.mysql.com/downloads/mysql/)

### 克隆仓库

```sh
git clone https://github.com/your-username/hiddenpoint.git
cd hiddenpoint
```

### 配置数据库

1. 创建数据库：

```sql
CREATE DATABASE hiddenpoint;
```

2. 在 `src/main/resources/application.properties` 文件中配置数据库连接：

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hiddenpoint
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.jpa.hibernate.ddl-auto=update
```

### 构建和运行项目

```sh
mvn clean install
mvn spring-boot:run
```

项目将运行在 `http://localhost:8080`。

### 访问应用

- 查看所有项目: [http://localhost:8080/projects/getallprojects](http://localhost:8080/projects/getallprojects)
- 查看所有页面: [http://localhost:8080/pages/getallpages](http://localhost:8080/pages/getallpages)
- 查看所有模块: [http://localhost:8080/modules/getallmodules](http://localhost:8080/modules/getallmodules)
- 查看所有事件: [http://localhost:8080/events/getallevents](http://localhost:8080/events/getallevents)
- 查看所有参数: [http://localhost:8080/parameters/getallparameters](http://localhost:8080/parameters/getallparameters)
- 查看所有页面模块关系: [http://localhost:8080/page-module-relations/getallrelations](http://localhost:8080/page-module-relations/getallrelations)
- 查看所有项目资源: [http://localhost:8080/project-resources/getallresources](http://localhost:8080/project-resources/getallresources)
