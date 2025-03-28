package org.example.admin.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 存储AI模型的配置信息
 * @TableName model_configs
 */
@TableName(value ="model_configs")
@Data
public class ModelConfigs implements Serializable {
    /**
     * 配置唯一标识
     */
    @TableId(type = IdType.AUTO)
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
     * 模型参数（JSON格式）
     */
    private Object parameters;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}