CREATE SCHEMA `subscriber` ;

CREATE TABLE `subscriber`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `gender` VARCHAR(45) NULL,
  `email_id` VARCHAR(255) NULL,
  `mobile_no` VARCHAR(45) NULL,
  `address` VARCHAR(255) NULL,
  `state` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `zip_code` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `subscriber`.`customers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NULL,
  `first_name` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `last_order_id` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE addresses (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
customer_id int(6) ,
address1 VARCHAR(255) NOT NULL,
city VARCHAR(30) NOT NULL,
province VARCHAR(30) NOT NULL,
zip VARCHAR(30) NOT NULL,
default_address boolean default false,
FOREIGN KEY (customer_id) REFERENCES customers(id)
)

CREATE TABLE `subscriber`.`products` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `collection_id` INT NULL,
  `product_id` INT NULL,
  `created_at` datetime NULL,
  `updated_at` datetime NULL,
  `position` VARCHAR(255) NULL,
  `sort_value` BIGINT NULL,
  PRIMARY KEY (`id`));