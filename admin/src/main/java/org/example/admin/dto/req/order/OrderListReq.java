package org.example.admin.dto.req.order;

import lombok.Data;


@Data
public class OrderListReq{

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 客户电话
     */
    private String customerPhone;

    /**
     * 支付状态（0未支付 1已支付 2已退款）
     */
    private Integer payStatus;

    /**
     * 订单状态（0待处理 1处理中 2已完成 3已取消）
     */
    private Integer orderStatus;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;
}