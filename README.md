# AI聊天室

## 项目简介
这是一个基于火山引擎AI能力打造的智能聊天室系统，提供流畅的人机对话体验。系统采用前后端分离架构，具有高性能、可扩展的特点。

## 核心功能
- 智能对话：基于火山引擎AI模型，支持自然语言理解和生成
- 实时响应：采用流式对话技术，实现即时通讯
- 会话管理：支持多轮对话历史记录和上下文理解
- 安全防护：完善的用户认证和数据加密机制

## 技术架构
### 后端技术栈
- Spring Boot：核心框架
- MyBatis：数据持久层框架
- MySQL：数据库
- SSE：聊天核心功能

### 前端技术栈
- Vue3.js：前端框架
- Ant Design UI：UI组件库
- Axios：HTTP客户端

## 快速开始
### 环境要求
- JDK 17+
- Maven 3.6+
- MySQL 5.7+

### 本地部署
1. 克隆项目
```bash
git clone [项目地址]
```

2. 配置数据库
- 执行`Resource/table.sql`创建数据库表
- 修改`application.properties`中的数据库配置

3. 启动服务
```bash
mvn spring-boot:run
```

4. 访问系统
```
http://localhost:7001
```

## API文档
### 对话接口
- POST /api/chat/stream
  - 发送消息到AI助手
  - 支持流式响应

### 会话管理
- GET /api/chat/history
  - 获取历史对话记录
- DELETE /api/chat/clear
  - 清空当前会话

## 安全说明
- 采用JWT进行身份认证
- 支持HTTPS加密传输

## 贡献指南
欢迎提交Issue和Pull Request，一起完善项目。

