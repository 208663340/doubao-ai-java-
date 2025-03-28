package org.example.admin.service;

import org.example.admin.dao.entity.OrderDO;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.admin.dto.req.order.CreateOrderReq;
import org.example.admin.dto.req.order.OrderListReq;
import org.example.admin.dto.resp.order.OrderDetailResp;
import org.example.admin.dto.resp.order.OrderListResp;

import java.util.List;

/**
* @author 20866
* @description 针对表【sys_order(订单主表)】的数据库操作Service
* @createdTimee 2025-03-27 13:40:39
*/
public interface SysOrderService extends IService<OrderDO> {

    Long createOrder(CreateOrderReq req);

    List<OrderListResp> getOrderList(OrderListReq req);

    OrderDetailResp getOrderDetail(Long orderId);

    Void updateOrderStatus(Long orderId, Integer status);

    Void cancelOrder(Long orderId);

}
