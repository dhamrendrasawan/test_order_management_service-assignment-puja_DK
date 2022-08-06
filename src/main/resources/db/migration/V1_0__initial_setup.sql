CREATE TABLE `customer` (
  `customer_Id` bigint NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `email_id` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `mobile_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`customer_Id`)
);

CREATE TABLE `orders` (
  `order_info_id` bigint NOT NULL AUTO_INCREMENT, 
  `create_date` datetime NOT NULL,
  `customer_id_Fk` bigint NOT NULL,
  `order_id` varchar(200) NOT NULL,
  `update_date` datetime NOT NULL,
   `code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`order_info_id`),
 CONSTRAINT `fk_orders` FOREIGN KEY (`customer_id_Fk`) REFERENCES `customer` (`customer_Id`)
);





CREATE TABLE `products` (
  `product_id` bigint NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `order_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
  );
  
  CREATE TABLE `address` (
  `addressid` bigint NOT NULL AUTO_INCREMENT,
  `address_type` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `landmark` varchar(255) NOT NULL,
  `pincode` varchar(255) NOT NULL,
  `state` varchar(255) NOT NULL,
  `street_name` varchar(255) NOT NULL,
  `customer_id` bigint NOT NULL,
  PRIMARY KEY (`addressid`),
  KEY `FK93c3js0e22ll1xlu21nvrhqgg` (`customer_id`)
  );



