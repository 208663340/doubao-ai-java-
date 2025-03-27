package org.example.admin.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 商品信息表
 * @TableName sys_product
 */
@TableName(value ="sys_product")
@Data
public class ProductDO implements Serializable {
    /**
     * 商品ID
     */
    @TableId(type = IdType.AUTO)
    private Long productId;

    /**
     * 商品编码（唯一）
     */
    private String productCode;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 分类ID
     */
    private Long categoryId;

    /**
     * 品牌ID
     */
    private Long brandId;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 原价（用于促销）
     */
    private BigDecimal originalPrice;

    /**
     * 库存数量
     */
    private Integer stockQuantity;

    /**
     * 商品详情描述
     */
    private String detailDescription;

    /**
     * 主图URL
     */
    private String mainImage;

    /**
     * 商品状态（1上架 2下架 3缺货）
     */
    private Integer status;

    /**
     * 销量
     */
    private Integer salesVolume;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}