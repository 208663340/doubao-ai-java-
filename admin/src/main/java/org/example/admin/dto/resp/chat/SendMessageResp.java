package org.example.admin.dto.resp.chat;

import lombok.Data;

import java.util.Date;

/**
 * 发送消息响应
 */
@Data
public class SendMessageResp {

    /**
     * 用户消息信息
     */
    private UserMessage userMessage;

    /**
     * AI回复信息
     */
    private AiMessage aiMessage;

    @Data
    public static class UserMessage {
        /**
         * 消息ID
         */
        private Integer messageId;

        /**
         * 发送时间
         */
        private Date createdTime;
    }

    @Data
    public static class AiMessage {
        /**
         * 消息ID
         */
        private Integer messageId;

        /**
         * 回复内容
         */
        private String content;

        /**
         * 回复时间
         */
        private Date createdTime;

        /**
         * 模型信息等元数据
         */
        private Object metadata;
    }
}