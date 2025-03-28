package org.example.admin.dto.req.chat;

import lombok.Data;

/**
 * 发送消息请求
 */
@Data
public class SendMessageReq {

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 消息内容
     */
    private String message;

    /**
     * 附加信息（可选）
     */
    private Object metadata;
}