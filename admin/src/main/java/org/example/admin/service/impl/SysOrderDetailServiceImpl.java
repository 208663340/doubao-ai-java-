package org.example.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.admin.dao.entity.OrderDetailDO;
import org.example.admin.dao.mapper.SysOrderDetailMapper;
import org.example.admin.service.SysOrderDetailService;
import org.springframework.stereotype.Service;

/**
* @author 20866
* @description 针对表【sys_order_detail(订单详情表)】的数据库操作Service实现
* @createdTimee 2025-03-27 13:40:37
*/
@Service
public class SysOrderDetailServiceImpl extends ServiceImpl<SysOrderDetailMapper, OrderDetailDO>
    implements SysOrderDetailService{

}




