package org.example.admin.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 存储AI生成的回复消息
 * @TableName ai_messages
 */
@TableName(value ="ai_messages")
@Data
public class AiMessages implements Serializable {
    /**
     * AI消息唯一标识
     */
    @TableId(type = IdType.AUTO)
    private Integer aiMessageId;

    /**
     * 关联的会话ID（手动维护关系）
     */
    private Integer sessionId;

    /**
     * 使用的AI模型配置ID（手动维护关系）
     */
    private Integer modelConfigId;

    /**
     * 消息内容
     */
    private String messageText;

    /**
     * 消息发送时间
     */
    private Date createdTime;

    /**
     * 附加信息（如模型使用的参数、推理时间等）
     */
    private Object metadata;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}