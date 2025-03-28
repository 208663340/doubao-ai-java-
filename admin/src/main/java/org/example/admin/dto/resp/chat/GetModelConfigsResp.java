package org.example.admin.dto.resp.chat;

import lombok.Data;

import java.util.List;

/**
 * 获取模型配置列表响应
 */
@Data
public class GetModelConfigsResp {

    /**
     * 模型配置列表
     */
    private List<ModelConfig> models;

    @Data
    public static class ModelConfig {
        /**
         * 配置ID
         */
        private Integer configId;

        /**
         * 模型名称
         */
        private String modelName;

        /**
         * 模型版本
         */
        private String modelVersion;

        /**
         * 模型参数
         */
        private Object parameters;
    }
}