# HiddenPoint Project

## 项目简介

HiddenPoint 是一个基于 Spring Boot 构建的 Web 应用程序。该项目展示了如何使用 Spring Boot 和 Thymeleaf 构建一个完整的 Web 应用程序，包括数据的增删改查 (CRUD) 操作。

## 主要功能

- **项目管理**：展示所有项目的列表，支持按 ID 查询单个项目。
- **页面管理**：展示所有页面的列表，支持按 ID 查询单个页面。
- **模块管理**：展示所有模块的列表，支持按 ID 查询单个模块。
- **事件管理**：展示所有事件的列表，支持按 ID 查询单个事件。
- **参数管理**：展示所有参数的列表，支持按 ID 查询单个参数。
- **项目资源管理**：展示所有项目资源的列表，支持按 ID 查询单个项目资源。
- **页面模块关系管理**：展示所有页面模块关系的列表，支持按 ID 查询单个页面模块关系。

## 技术栈

- **后端**：
  - Spring Boot
  - Spring Data JPA
  - Hibernate
  - MySQL

- **前端**：
  - Thymeleaf
  - Bootstrap

## 项目结构

```
hiddenpoint
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── shaohua
│   │   │           └── hiddenpoint
│   │   │               ├── controller
│   │   │               │   ├── ProjectController.java
│   │   │               │   ├── PageController.java
│   │   │               │   ├── ModuleController.java
│   │   │               │   ├── EventController.java
│   │   │               │   ├── ParameterController.java
│   │   │               │   ├── ProjectResourceController.java
│   │   │               │   └── PageModuleRelationController.java
│   │   │               ├── entity
│   │   │               │   ├── ProjectEntity.java
│   │   │               │   ├── PageEntity.java
│   │   │               │   ├── ModuleEntity.java
│   │   │               │   ├── EventEntity.java
│   │   │               │   ├── ParameterEntity.java
│   │   │               │   ├── ProjectResourceEntity.java
│   │   │               │   └── PageModuleRelationEntity.java
│   │   │               ├── repository
│   │   │               │   ├── ProjectRepository.java
│   │   │               │   ├── PageRepository.java
│   │   │               │   ├── ModuleRepository.java
│   │   │               │   ├── EventRepository.java
│   │   │               │   ├── ParameterRepository.java
│   │   │               │   ├── ProjectResourceRepository.java
│   │   │               │   └── PageModuleRelationRepository.java
│   │   │               ├── service
│   │   │               │   ├── ProjectService.java
│   │   │               │   ├── PageService.java
│   │   │               │   ├── ModuleService.java
│   │   │               │   ├── EventService.java
│   │   │               │   ├── ParameterService.java
│   │   │               │   ├── ProjectResourceService.java
│   │   │               │   └── PageModuleRelationService.java
│   │   │               └── service.impl
│   │   │                   ├── ProjectServiceImpl.java
│   │   │                   ├── PageServiceImpl.java
│   │   │                   ├── ModuleServiceImpl.java
│   │   │                   ├── EventServiceImpl.java
│   │   │                   ├── ParameterServiceImpl.java
│   │   │                   ├── ProjectResourceServiceImpl.java
│   │   │                   └── PageModuleRelationServiceImpl.java
│   │   ├── resources
│   │   │   ├── templates
│   │   │   │   └── projects.html
│   │   │   │   └── pages.html
│   │   │   │   └── modules.html
│   │   │   │   └── events.html
│   │   │   │   └── parameters.html
│   │   │   │   └── project-resources.html
│   │   │   │   └── page-module-relations.html
│   │   │   ├── application.properties
├── pom.xml
└── README.md
```

## 运行项目

### 前提条件

- 安装 Java 11 或更高版本
- 安装 MySQL 数据库
- 安装 Maven

### 步骤

1. 克隆项目到本地：
    ```sh
    git clone https://github.com/yourusername/hiddenpoint.git
    cd hiddenpoint
    ```

2. 配置数据库连接：
    - 修改 `src/main/resources/application.properties` 文件中的数据库连接配置：
        ```properties
        spring.datasource.url=jdbc:mysql://localhost:3306/yourdatabase
        spring.datasource.username=yourusername
        spring.datasource.password=yourpassword
        spring.jpa.hibernate.ddl-auto=update
        ```

3. 编译并运行项目：
    ```sh
    mvn spring-boot:run
    ```

4. 在浏览器中打开 [http://localhost:8080/projects](http://localhost:8080/projects) 查看项目列表。
