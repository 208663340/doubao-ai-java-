package org.example.admin.dto.req.order;

import com.esotericsoftware.kryo.serializers.FieldSerializer;
import lombok.Data;


import java.util.List;

@Data
public class CreateOrderReq {

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 客户电话
     */

    private String customerPhone;

    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 订单明细列表
     */
    private List<OrderDetailItem> orderDetails;

    /**
     * 备注
     */
    private String remark;

    @Data
    public static class OrderDetailItem {
        /**
         * 产品ID
         */
        private Long productId;

        /**
         * 购买数量
         */
        private Integer quantity;
    }
}