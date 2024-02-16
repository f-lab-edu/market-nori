-- member 테이블 생성
CREATE TABLE `member` (
    `member_id` bigint NOT NULL AUTO_INCREMENT,
    `id` varchar(255) NOT NULL,
    `password` varchar(255) NOT NULL,
    `name` varchar(255) NOT NULL,
    `phone` varchar(255) NOT NULL,
    `email` varchar(255) NULL,
    `address` varchar(255) NOT NULL,
    `created_at` datetime(6) NULL,
    `create_by` varchar(255) NULL,
    `update_at` datetime(6) NULL,
    `update_by` varchar(255) NULL,
    PRIMARY KEY (`member_id`),
    UNIQUE KEY `id_unique` (id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- product_category 테이블 생성
CREATE TABLE `product_category` (
    `category_id` bigint NOT NULL AUTO_INCREMENT,
    `category_name` varchar(255) NOT NULL,
    `created_at` datetime(6) NULL,
    `create_by` varchar(255) NULL,
    `update_at` datetime(6) NULL,
    `update_by` varchar(255) NULL,
    PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- product 테이블 생성
CREATE TABLE `product` (
    `product_id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    `price` bigint NOT NULL,
    `stock_quantity` bigint NOT NULL,
    `sale_end_date` datetime(6) DEFAULT NULL,
    `sale_start_date` datetime(6) DEFAULT NULL,
    `category_id` bigint NOT NULL,
    `created_at` datetime(6) NULL,
    `create_by` varchar(255) NULL,
    `update_at` datetime(6) NULL,
    `update_by` varchar(255) NULL,
    PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- cart 테이블 생성
CREATE TABLE `cart` (
    `cart_id` bigint NOT NULL AUTO_INCREMENT,
    `member_id` bigint NOT NULL,
    `created_at` datetime(6) NULL,
    `create_by` varchar(255) NULL,
    `update_at` datetime(6) NULL,
    `update_by` varchar(255) NULL,
    PRIMARY KEY (`cart_id`),
    UNIQUE KEY `member_id_unique` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- cart_item 테이블 생성
CREATE TABLE `cart_item` (
    `cart_item_id` bigint NOT NULL AUTO_INCREMENT,
    `cart_id` bigint NOT NULL,
    `product_id` bigint NOT NULL,
    `quantity` bigint NOT NULL,
    `created_at` datetime(6) NULL,
    `create_by` varchar(255) NULL,
    `update_at` datetime(6) NULL,
    `update_by` varchar(255) NULL,
    PRIMARY KEY (`cart_item_id`),
    UNIQUE KEY `cart_product_unique` (`cart_id`, `product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- order 테이블 생성
CREATE TABLE `order` (
    `order_id` bigint NOT NULL AUTO_INCREMENT,
    `member_id` bigint NOT NULL,
    `shipping_address` varchar(255) NOT NULL,
    `status` varchar(64) DEFAULT NULL,
    `created_at` datetime(6) NULL,
    `create_by` varchar(255) NULL,
    `update_at` datetime(6) NULL,
    `update_by` varchar(255) NULL,
    PRIMARY KEY (`order_id`),
    UNIQUE KEY `member_unique` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- order_detail 테이블 생성
CREATE TABLE `order_detail` (
    `order_item_id` bigint NOT NULL AUTO_INCREMENT,
    `order_id` bigint NOT NULL,
    `product_id` bigint NOT NULL,
    `order_price` bigint NOT NULL,
    `quantity` bigint NOT NULL,
    `created_at` datetime(6) NULL,
    `create_by` varchar(255) NULL,
    `update_at` datetime(6) NULL,
    `update_by` varchar(255) NULL,
    PRIMARY KEY (`order_item_id`),
    UNIQUE KEY `order_product_unique` (`order_id`, `product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- payment 테이블 생성
CREATE TABLE `payment` (
    `payment_id` bigint NOT NULL AUTO_INCREMENT,
    `order_id` bigint NOT NULL,
    `payment_method` varchar(255) NOT NULL,
    `amount` bigint NOT NULL,
    `status` varchar(64) NOT NULL,
    `created_at` datetime(6) NULL,
    `create_by` varchar(255) NULL,
    `update_at` datetime(6) NULL,
    `update_by` varchar(255) NULL,
    PRIMARY KEY (`payment_id`),
    UNIQUE KEY `order_payment_method_unique` (`order_id`, `payment_method`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;