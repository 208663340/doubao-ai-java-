# create table book
# (
#     id          int auto_increment
#         primary key,
#     user_id     varchar(1024)     null,
#     book_name   varchar(1024)     null,
#     update_time datetime          null,
#     create_time datetime          null,
#     del_flag    tinyint default 0 null
# );
-- auto-generated definition
CREATE TABLE `sys_user` (
                            `user_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '用户ID',
                            `username` VARCHAR(64) NOT NULL COMMENT '用户名',
                            `password` VARCHAR(100) NOT NULL COMMENT '加密密码',
                            `email` VARCHAR(128) COMMENT '邮箱地址',
                            `mobile` VARCHAR(20) COMMENT '手机号码',
                            `gender` TINYINT NOT NULL DEFAULT 0 COMMENT '性别（0未知 1男 2女）',
                            `status` TINYINT NOT NULL DEFAULT 1 COMMENT '状态（1启用 0禁用）',
#                             `create_by` VARCHAR(64) NOT NULL COMMENT '创建人',
                            `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            `update_by` VARCHAR(64) COMMENT '更新人',
                            `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                            PRIMARY KEY (`user_id`),
                            UNIQUE KEY `idx_username` (`username`),
                            UNIQUE KEY `idx_email` (`email`),
                            UNIQUE KEY `idx_mobile` (`mobile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表';


-- 系统订单表
CREATE TABLE `sys_order` (
                             `order_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '订单ID',
                             `order_no` VARCHAR(32) NOT NULL COMMENT '订单编号',
                             `user_id` BIGINT NOT NULL COMMENT '用户ID',
                             `user_name` VARCHAR(64) NOT NULL COMMENT '用户名称',
                             `dept_id` BIGINT COMMENT '部门ID',
                             `customer_name` VARCHAR(64) NOT NULL COMMENT '客户名称',
                             `customer_phone` VARCHAR(20) NOT NULL COMMENT '客户电话',
                             `total_amount` DECIMAL(10,2) NOT NULL DEFAULT 0.00 COMMENT '订单总金额',
                             `pay_status` TINYINT NOT NULL DEFAULT 0 COMMENT '支付状态（0未支付 1已支付 2已退款）',
                             `order_status` TINYINT NOT NULL DEFAULT 0 COMMENT '订单状态（0待处理 1处理中 2已完成 3已取消）',
                             `pay_time` DATETIME COMMENT '支付时间',
                             `create_by` VARCHAR(64) NOT NULL COMMENT '创建人',
                             `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                             `update_by` VARCHAR(64) COMMENT '更新人',
                             `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                             `remark` TEXT COMMENT '备注',
                             PRIMARY KEY (`order_id`),
                             UNIQUE KEY `idx_order_no` (`order_no`),
                             KEY `idx_user_id` (`user_id`),
                             KEY `idx_pay_status` (`pay_status`),
                             KEY `idx_order_status` (`order_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单主表';

-- 订单明细表
CREATE TABLE `sys_order_detail` (
                                    `detail_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '明细ID',
                                    `order_id` BIGINT NOT NULL COMMENT '所属订单ID',
                                    `product_id` BIGINT NOT NULL COMMENT '产品ID',
                                    `product_name` VARCHAR(128) NOT NULL COMMENT '产品名称',
                                    `product_price` DECIMAL(10,2) NOT NULL DEFAULT 0.00 COMMENT '产品单价',
                                    `quantity` INT NOT NULL DEFAULT 0 COMMENT '购买数量',
                                    `total_price` DECIMAL(10,2) NOT NULL DEFAULT 0.00 COMMENT '小计金额',
                                    `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                    PRIMARY KEY (`detail_id`),
                                    KEY `idx_order_id` (`order_id`),
                                    KEY `idx_product_id` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单详情表';

-- 支付记录表
CREATE TABLE `sys_payment` (
                               `payment_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '支付ID',
                               `order_id` BIGINT NOT NULL COMMENT '关联订单ID',
                               `payment_no` VARCHAR(32) NOT NULL COMMENT '支付单号',
                               `amount` DECIMAL(10,2) NOT NULL DEFAULT 0.00 COMMENT '支付金额',
                               `channel` VARCHAR(16) NOT NULL COMMENT '支付渠道（ALIPAY/WECHAT）',
                               `status` TINYINT NOT NULL DEFAULT 0 COMMENT '支付状态',
                               `callback_data` TEXT COMMENT '支付回调数据',
                               `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                               `complete_time` DATETIME COMMENT '完成时间',
                               PRIMARY KEY (`payment_id`),
                               UNIQUE KEY `idx_payment_no` (`payment_no`),
                               KEY `idx_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='支付记录表';
-- 商品表
CREATE TABLE `sys_product` (
                               `product_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '商品ID',
                               `product_code` VARCHAR(32) NOT NULL COMMENT '商品编码（唯一）',
                               `product_name` VARCHAR(255) NOT NULL COMMENT '商品名称',
                               `category_id` BIGINT NOT NULL COMMENT '分类ID',
                               `brand_id` BIGINT COMMENT '品牌ID',
                               `price` DECIMAL(10,2) NOT NULL DEFAULT 0.00 COMMENT '商品价格',
                               `original_price` DECIMAL(10,2) COMMENT '原价（用于促销）',
                               `stock_quantity` INT NOT NULL DEFAULT 0 COMMENT '库存数量',
                               `detail_description` TEXT COMMENT '商品详情描述',
                               `main_image` VARCHAR(255) COMMENT '主图URL',
                               `status` TINYINT NOT NULL DEFAULT 1 COMMENT '商品状态（1上架 2下架 3缺货）',
                               `sales_volume` INT NOT NULL DEFAULT 0 COMMENT '销量',
                               `create_by` VARCHAR(64) NOT NULL COMMENT '创建人',
                               `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                               `update_by` VARCHAR(64) COMMENT '更新人',
                               `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                               PRIMARY KEY (`product_id`),
                               UNIQUE KEY `idx_product_code` (`product_code`),
                               KEY `idx_category_id` (`category_id`),
                               KEY `idx_product_name` (`product_name`),
                               KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品信息表';

CREATE TABLE user_messages (
                               user_message_id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '用户消息唯一标识', -- 用户消息唯一标识
                               session_id CHAR(36) NOT NULL COMMENT '关联的会话ID（手动维护关系）',            -- 关联的会话ID
                               user_id INT NOT NULL COMMENT '发送消息的用户ID（手动维护关系）',           -- 发送消息的用户ID
                               message_text TEXT NOT NULL COMMENT '消息内容',                             -- 消息内容
                               created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '消息发送时间',     -- 消息发送时间
                               metadata JSON DEFAULT NULL COMMENT '附加信息（如情感分析结果、实体识别结果等）', -- 附加信息
                               INDEX idx_session_id (session_id)                                          -- 为 session_id 添加索引
) COMMENT='存储用户发送的消息';
CREATE TABLE ai_messages (
                             ai_message_id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT 'AI消息唯一标识', -- AI消息唯一标识
                             session_id CHAR(36) NOT NULL COMMENT '关联的会话ID（手动维护关系）',        -- 关联的会话ID
                             model_config_id INT DEFAULT NULL COMMENT '使用的AI模型配置ID（手动维护关系）', -- 使用的AI模型配置ID
                             message_text TEXT NOT NULL COMMENT '消息内容',                         -- 消息内容
                             created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '消息发送时间', -- 消息发送时间
                             metadata JSON DEFAULT NULL COMMENT '附加信息（如模型使用的参数、推理时间等）', -- 附加信息
                             INDEX idx_session_id (session_id)                                      -- 为 session_id 添加索引
) COMMENT='存储AI生成的回复消息';

CREATE TABLE model_configs (
                               config_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '配置唯一标识', -- 配置唯一标识
                               model_name VARCHAR(100) NOT NULL COMMENT '模型名称',           -- 模型名称
                               model_version VARCHAR(50) COMMENT '模型版本',                  -- 模型版本
                               parameters JSON DEFAULT NULL COMMENT '模型参数（JSON格式）',   -- 模型参数
                               created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间', -- 创建时间
                               updated_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间', -- 更新时间
                               INDEX idx_model_name (model_name)                              -- 为 model_name 添加索引
) COMMENT='存储AI模型的配置信息';

CREATE TABLE logs (
                      log_id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '日志唯一标识', -- 日志唯一标识
                      level ENUM('info', 'warning', 'error') NOT NULL COMMENT '日志级别', -- 日志级别
                      message TEXT NOT NULL COMMENT '日志消息',                     -- 日志消息
                      created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间', -- 创建时间
                      INDEX idx_level (level)                                       -- 为 level 添加索引
) COMMENT='记录系统操作日志';