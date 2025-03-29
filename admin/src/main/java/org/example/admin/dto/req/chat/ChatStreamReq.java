package org.example.admin.dto.req.chat;

import lombok.Data;

/**
 * 流式对话请求
 */
@Data
public class ChatStreamReq {
    /**
     * 用户输入的消息
     */
    private String message;

    /**
     * 会话ID
     */
    private Integer sessionId;

    /**
     * 模型配置ID
     */
    private Integer modelConfigId;
}