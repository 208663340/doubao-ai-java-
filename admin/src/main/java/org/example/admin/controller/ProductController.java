package org.example.admin.controller;

import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.example.admin.comoon.convention.result.Result;
import org.example.admin.comoon.convention.result.Results;
import org.example.admin.dao.entity.ProductDO;
import org.example.admin.dto.req.product.ProductAddReqDTO;
import org.example.admin.service.SysProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ProductController {
    @Resource
    private SysProductService productService;

    /**
     * 根据商品编码获取商品
     */
    @GetMapping("/api/crud/admin/v1/product/{productId}")
    public Result<ProductDO> getProductById(@PathVariable("productId") Long productId) {
        return Results.success(productService.getUserByUsername(productId));
    }
    /**
     * 获取分类的商品列表
     */
    @GetMapping("/api/crud/admin/v1/product/{categoryId}")
    public Result<ProductDO> getProductByCategory(@PathVariable Long categoryId) {
        return Results.success(productService.getProductByCategory(categoryId));
    }
    /**
     * 根据品牌获取商品
     */
    @GetMapping("/api/crud/admin/v1/product/{brandId}")
    public Result<ProductDO> getProductByBrandId(@PathVariable Long brandId) {
        return Results.success(productService.getProductByBrandId(brandId));
    }
    /**
     * 根据商品名称获取商品
     */
    @GetMapping("/api/crud/admin/v1/product/{productName}")
    public Result<ProductDO> getProductByName(@PathVariable String productName) {
        return Results.success(productService.getProductByName(productName));
    }

    /**
     * 上传商品
     */
    @PostMapping("/api/crud/admin/v1/product/add")
    public Result<ProductDO> addProduct(@RequestBody ProductAddReqDTO productAddReqDTO) {
        return Results.success(productService.addProduct(productAddReqDTO));
    }
}
