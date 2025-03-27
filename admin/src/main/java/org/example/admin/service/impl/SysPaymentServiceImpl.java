package org.example.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.admin.dao.entity.PaymentDO;
import org.example.admin.service.SysPaymentService;
import org.example.admin.dao.mapper.SysPaymentMapper;
import org.springframework.stereotype.Service;

/**
* @author 20866
* @description 针对表【sys_payment(支付记录表)】的数据库操作Service实现
* @createDate 2025-03-27 13:40:33
*/
@Service
public class SysPaymentServiceImpl extends ServiceImpl<SysPaymentMapper, PaymentDO>
    implements SysPaymentService{

}




