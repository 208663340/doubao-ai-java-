package org.example.admin.dto.resp.chat;

import lombok.Data;

/**
 * 流式对话响应
 */
@Data
public class ChatStreamResp {
    /**
     * 消息内容
     */
    private String content;

    /**
     * 是否是最后一条消息
     */
    private boolean isEnd;

    /**
     * 错误信息，如果有的话
     */
    private String error;
}