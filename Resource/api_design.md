# AI聊天系统API接口设计文档

## 1. 会话管理接口

### 1.1 创建新会话
- **接口**：`POST /api/v1/sessions`
- **描述**：创建新的对话会话
- **请求参数**：
  ```json
  {
    "user_id": "用户ID",
    "model_config_id": "可选，指定使用的AI模型配置ID"
  }
  ```
- **响应**：
  ```json
  {
    "code": 200,
    "data": {
      "session_id": "会话ID"
    }
  }
  ```

### 1.2 获取会话历史
- **接口**：`GET /api/v1/sessions/{session_id}/messages`
- **描述**：获取指定会话的历史消息记录
- **请求参数**：
  - `page_size`：每页记录数
  - `page_num`：页码
- **响应**：
  ```json
  {
    "code": 200,
    "data": {
      "messages": [
        {
          "message_id": "消息ID",
          "type": "user/ai",
          "content": "消息内容",
          "created_time": "发送时间",
          "metadata": "附加信息"
        }
      ],
      "total": "总记录数"
    }
  }
  ```

## 2. 消息交互接口

### 2.1 发送用户消息
- **接口**：`POST /api/v1/sessions/{session_id}/messages`
- **描述**：发送用户消息并获取AI回复
- **请求参数**：
  ```json
  {
    "user_id": "用户ID",
    "message": "消息内容",
    "metadata": "可选，附加信息"
  }
  ```
- **响应**：
  ```json
  {
    "code": 200,
    "data": {
      "user_message": {
        "message_id": "用户消息ID",
        "created_time": "发送时间"
      },
      "ai_message": {
        "message_id": "AI消息ID",
        "content": "AI回复内容",
        "created_time": "回复时间",
        "metadata": "模型信息等"
      }
    }
  }
  ```

## 3. 模型配置接口

### 3.1 获取可用模型列表
- **接口**：`GET /api/v1/model-configs`
- **描述**：获取系统中可用的AI模型配置
- **响应**：
  ```json
  {
    "code": 200,
    "data": {
      "models": [
        {
          "config_id": "配置ID",
          "model_name": "模型名称",
          "model_version": "版本",
          "parameters": "模型参数"
        }
      ]
    }
  }
  ```

### 3.2 更新模型配置
- **接口**：`PUT /api/v1/model-configs/{config_id}`
- **描述**：更新指定模型的配置参数
- **请求参数**：
  ```json
  {
    "model_name": "可选，模型名称",
    "model_version": "可选，版本",
    "parameters": "模型参数JSON"
  }
  ```
- **响应**：
  ```json
  {
    "code": 200,
    "data": {
      "config_id": "配置ID",
      "updated_time": "更新时间"
    }
  }
  ```

## 4. 系统管理接口

### 4.1 获取系统日志
- **接口**：`GET /api/v1/logs`
- **描述**：获取系统操作日志
- **请求参数**：
  - `level`：日志级别（info/warning/error）
  - `start_time`：开始时间
  - `end_time`：结束时间
  - `page_size`：每页记录数
  - `page_num`：页码
- **响应**：
  ```json
  {
    "code": 200,
    "data": {
      "logs": [
        {
          "log_id": "日志ID",
          "level": "日志级别",
          "message": "日志内容",
          "created_time": "创建时间"
        }
      ],
      "total": "总记录数"
    }
  }
  ```

## 5. 错误码说明

- 200：成功
- 400：请求参数错误
- 401：未授权
- 403：禁止访问
- 404：资源不存在
- 500：服务器内部错误

## 6. 注意事项

1. 所有接口都需要进行用户认证
2. 消息内容支持文本格式
3. 模型配置更新后需要重新初始化模型
4. 建议客户端实现消息重试机制
5. 系统日志按时间倒序排列