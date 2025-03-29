package org.example.admin.dto.resp.order;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class OrderListResp {

    /**
     * 订单ID
     */
    private Long orderId;

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
     * 订单总金额
     */
    private BigDecimal totalAmount;

    /**
     * 支付状态（0未支付 1已支付 2已退款）
     */
    private Integer payStatus;

    /**
     * 订单状态（0待处理 1处理中 2已完成 3已取消）
     */
    private Integer orderStatus;

    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 备注
     */
    private String remark;

    /**
     * 订单明细列表
     */
    private List<OrderDetailItem> orderDetails;

    @Data
    public static class OrderDetailItem {
        /**
         * 明细ID
         */
        private Long detailId;

        /**
         * 产品ID
         */
        private Long productId;

        /**
         * 产品名称
         */
        private String productName;

        /**
         * 产品单价
         */
        private BigDecimal productPrice;

        /**
         * 购买数量
         */
        private Integer quantity;

        /**
         * 小计金额
         */
        private BigDecimal totalPrice;
    }
}