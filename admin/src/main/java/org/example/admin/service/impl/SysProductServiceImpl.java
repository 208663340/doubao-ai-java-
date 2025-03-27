package org.example.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.admin.dao.entity.ProductDO;
import org.example.admin.service.SysProductService;
import org.example.admin.dao.mapper.SysProductMapper;
import org.springframework.stereotype.Service;

/**
* @author 20866
* @description 针对表【sys_product(商品信息表)】的数据库操作Service实现
* @createDate 2025-03-27 13:47:31
*/
@Service
public class SysProductServiceImpl extends ServiceImpl<SysProductMapper, ProductDO>
    implements SysProductService{

}




