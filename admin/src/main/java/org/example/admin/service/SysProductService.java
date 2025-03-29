package org.example.admin.service;

import org.example.admin.dao.entity.ProductDO;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.admin.dto.req.product.ProductAddReqDTO;

/**
* @author 20866
* @description 针对表【sys_product(商品信息表)】的数据库操作Service
* @createdTimee 2025-03-27 13:47:31
*/
public interface SysProductService extends IService<ProductDO> {

    ProductDO getUserByUsername(Long productId);

    ProductDO getProductByCategory(Long categoryId);

    ProductDO getProductByBrandId(Long brandId);

    ProductDO getProductByName(String productName);

    ProductDO addProduct(ProductAddReqDTO productAddReqDTO);

}
