package org.example.admin.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 支付记录表
 * @TableName sys_payment
 */
@TableName(value ="sys_payment")
@Data
public class PaymentDO implements Serializable {
    /**
     * 支付ID
     */
    @TableId(type = IdType.AUTO)
    private Long paymentId;

    /**
     * 关联订单ID
     */
    private Long orderId;

    /**
     * 支付单号
     */
    private String paymentNo;

    /**
     * 支付金额
     */
    private BigDecimal amount;

    /**
     * 支付渠道（ALIPAY/WECHAT）
     */
    private String channel;

    /**
     * 支付状态
     */
    private Integer status;

    /**
     * 支付回调数据
     */
    private String callbackData;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 完成时间
     */
    private Date completeTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}