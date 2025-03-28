package org.example.admin.controller;

import jakarta.annotation.Resource;
import org.example.admin.comon.convention.result.Result;
import org.example.admin.comon.convention.result.Results;
import org.example.admin.dto.req.order.CreateOrderReq;
import org.example.admin.dto.req.order.OrderListReq;
import org.example.admin.dto.resp.order.OrderDetailResp;
import org.example.admin.dto.resp.order.OrderListResp;
import org.example.admin.service.SysOrderService;
import org.example.admin.service.SysUserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Resource
    private SysUserService userService;

    @Resource
    private SysOrderService sysOrderService;

    /**
     * 创建订单
     */
    @PostMapping("/create")
    public Result<Long> createOrder(@RequestBody @Validated CreateOrderReq req) {
        return Results.success(sysOrderService.createOrder(req));
    }

    /**
     * 获取订单列表
     */
    @GetMapping("/list")
    public Result<List<OrderListResp>> getOrderList(@Validated OrderListReq req) {
        return Results.success(sysOrderService.getOrderList(req));
    }

    /**
     * 获取订单详情
     */
    @GetMapping("/detail/{orderId}")
    public Result<OrderDetailResp> getOrderDetail(@PathVariable Long orderId) {
        return Results.success(sysOrderService.getOrderDetail(orderId));
    }

    /**
     * 更新订单状态
     */
    @PutMapping("/status/{orderId}")
    public Result<Void> updateOrderStatus(@PathVariable Long orderId, @RequestParam Integer status) {
        return Results.success(sysOrderService.updateOrderStatus(orderId, status));
    }

    /**
     * 取消订单
     */
    @PutMapping("/cancel/{orderId}")
    public Result<Void> cancelOrder(@PathVariable Long orderId) {
        return Results.success(sysOrderService.cancelOrder(orderId));
    }
}