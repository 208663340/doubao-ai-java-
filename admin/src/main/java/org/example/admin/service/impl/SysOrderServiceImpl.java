package org.example.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.admin.dao.entity.OrderDO;
import org.example.admin.dto.req.order.CreateOrderReq;
import org.example.admin.dto.req.order.OrderListReq;
import org.example.admin.dto.resp.order.OrderDetailResp;
import org.example.admin.dto.resp.order.OrderListResp;
import org.example.admin.service.SysOrderService;
import org.example.admin.dao.mapper.SysOrderMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 20866
* @description 针对表【sys_order(订单主表)】的数据库操作Service实现
* @createdTimee 2025-03-27 13:40:39
*/
@Service
public class SysOrderServiceImpl extends ServiceImpl<SysOrderMapper, OrderDO>
    implements SysOrderService{

    @Override
    public Long createOrder(CreateOrderReq req) {
        return 0L;
    }

    @Override
    public List<OrderListResp> getOrderList(OrderListReq req) {
        return List.of();
    }

    @Override
    public OrderDetailResp getOrderDetail(Long orderId) {
        return null;
    }

    @Override
    public Void updateOrderStatus(Long orderId, Integer status) {
        return null;
    }

    @Override
    public Void cancelOrder(Long orderId) {
        return null;
    }
}




