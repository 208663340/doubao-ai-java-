package org.example.admin.dto.req.chat;

import lombok.Data;

/**
 * 更新模型配置请求
 */
@Data
public class UpdateModelConfigReq {

    /**
     * 模型名称（可选）
     */
    private String modelName;

    /**
     * 模型版本（可选）
     */
    private String modelVersion;

    /**
     * 模型参数
     */
    private Object parameters;
}