package org.example.admin.dto.resp.chat;

import lombok.Data;

import java.util.Date;

/**
 * 更新模型配置响应
 */
@Data
public class UpdateModelConfigResp {

    /**
     * 配置ID
     */
    private Integer configId;

    /**
     * 更新时间
     */
    private Date updatedTime;
}