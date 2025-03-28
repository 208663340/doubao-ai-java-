package org.example.admin.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 记录系统操作日志
 * @TableName logs
 */
@TableName(value ="logs")
@Data
public class Logs implements Serializable {
    /**
     * 日志唯一标识
     */
    @TableId(type = IdType.AUTO)
    private Integer logId;

    /**
     * 日志级别
     */
    private Object level;

    /**
     * 日志消息
     */
    private String message;

    /**
     * 创建时间
     */
    private Date createdAt;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}