package org.example.admin.controller;

import jakarta.annotation.Resource;
import org.example.admin.comoon.convention.result.Result;
import org.example.admin.comoon.convention.result.Results;
import org.example.admin.dto.req.UserLoginReqDTO;
import org.example.admin.dto.req.UserRegisterReqDTO;
import org.example.admin.dto.req.UserUpdateReqDTO;
import org.example.admin.dto.resp.UserLoginRespDTO;
import org.example.admin.dto.resp.UserRespDTO;
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
