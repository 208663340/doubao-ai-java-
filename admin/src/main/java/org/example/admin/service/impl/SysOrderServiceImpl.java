package org.example.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.admin.dao.entity.OrderDO;
import org.example.admin.service.SysOrderService;
import org.example.admin.dao.mapper.SysOrderMapper;
import org.springframework.stereotype.Service;

/**
* @author 20866
* @description 针对表【sys_order(订单主表)】的数据库操作Service实现
* @createDate 2025-03-27 13:40:39
*/
@Service
public class SysOrderServiceImpl extends ServiceImpl<SysOrderMapper, OrderDO>
    implements SysOrderService{

}




