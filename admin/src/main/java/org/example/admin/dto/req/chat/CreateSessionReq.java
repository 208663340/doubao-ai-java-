package org.example.admin.dto.req.chat;

import lombok.Data;

/**
 * 创建会话请求
 */
@Data
public class CreateSessionReq {

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 指定使用的AI模型配置ID（可选）
     */
    private Integer modelConfigId;
}