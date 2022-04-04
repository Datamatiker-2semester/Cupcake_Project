-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema cupcake
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cupcake
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cupcake` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema test_db
-- -----------------------------------------------------
USE `cupcake` ;

-- -----------------------------------------------------
-- Table `cupcake`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcake`.`user` (
                                                `user_id` INT NOT NULL AUTO_INCREMENT,
                                                `username` VARCHAR(45) NOT NULL,
                                                `password` VARCHAR(45) NOT NULL,
                                                `role` VARCHAR(45) NOT NULL,
                                                `email` VARCHAR(45) NOT NULL,
                                                `balance` INT NOT NULL,
                                                PRIMARY KEY (`user_id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cupcake`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcake`.`user` (
                                                `user_id` INT NOT NULL AUTO_INCREMENT,
                                                `username` VARCHAR(45) NOT NULL,
                                                `password` VARCHAR(45) NOT NULL,
                                                `role` VARCHAR(45) NOT NULL,
                                                `email` VARCHAR(45) NOT NULL,
                                                `balance` INT NOT NULL,
                                                PRIMARY KEY (`user_id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cupcake`.`topping`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcake`.`topping` (
                                                   `topping_id` INT NOT NULL AUTO_INCREMENT,
                                                   `topping_name` VARCHAR(45) NOT NULL,
                                                   `topping_price` INT NOT NULL,
                                                   PRIMARY KEY (`topping_id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cupcake`.`bottom`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcake`.`bottom` (
                                                  `bottom_id` INT NOT NULL AUTO_INCREMENT,
                                                  `bottom_name` VARCHAR(45) NOT NULL,
                                                  `buttom_price` INT NOT NULL,
                                                  PRIMARY KEY (`bottom_id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cupcake`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcake`.`orders` (
                                                  `order_id` INT NOT NULL AUTO_INCREMENT,
                                                  `customer_username` VARCHAR(45) NOT NULL,
                                                  `order_date` DATE NOT NULL,
                                                  `status` VARCHAR(45) NOT NULL,
                                                  `order_amount` INT NOT NULL,
                                                  PRIMARY KEY (`order_id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cupcake`.`orderlines`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcake`.`orderlines` (
                                                      `orderline_id` INT NOT NULL AUTO_INCREMENT,
                                                      `order_id` INT NOT NULL,
                                                      `quantity` INT NOT NULL,
                                                      `cupcake_topping` VARCHAR(45) NOT NULL,
                                                      `cupcake_bottom` VARCHAR(45) NOT NULL,
                                                      `price` INT NOT NULL,
                                                      PRIMARY KEY (`orderline_id`))
    ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
