package org.example.admin.controller;

import jakarta.annotation.Resource;
import org.example.admin.service.SysOrderService;
import org.example.admin.service.SysUserService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class OrderController {

    @Resource
    private SysUserService userService;

    @Resource
    private SysOrderService sysOrderService;



}
