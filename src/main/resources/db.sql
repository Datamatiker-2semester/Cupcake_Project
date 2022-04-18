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
DROP SCHEMA IF EXISTS `cupcake` ;

-- -----------------------------------------------------
-- Schema cupcake
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cupcake` DEFAULT CHARACTER SET utf8 ;
USE `cupcake` ;

-- -----------------------------------------------------
-- Table `cupcake`.`bottom`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cupcake`.`bottom` ;

CREATE TABLE IF NOT EXISTS `cupcake`.`bottom` (
                                                  `bottom_id` INT NOT NULL AUTO_INCREMENT,
                                                  `bottom_name` VARCHAR(45) NOT NULL,
                                                  `bottom_price` INT NOT NULL,
                                                  PRIMARY KEY (`bottom_id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 6
    DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `cupcake`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cupcake`.`user` ;

CREATE TABLE IF NOT EXISTS `cupcake`.`user` (
                                                `user_id` INT NOT NULL AUTO_INCREMENT,
                                                `username` VARCHAR(45) NOT NULL,
                                                `password` VARCHAR(45) NOT NULL,
                                                `email` VARCHAR(45) NOT NULL,
                                                `role` VARCHAR(45) NOT NULL DEFAULT 'costumer',
                                                `balance` INT NOT NULL DEFAULT '500',
                                                PRIMARY KEY (`user_id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 20
    DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `cupcake`.`order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cupcake`.`order` ;

CREATE TABLE IF NOT EXISTS `cupcake`.`order` (
                                                 `order_id` INT NOT NULL AUTO_INCREMENT,
                                                 `user_id` INT NOT NULL,
                                                 `order_date` DATE NOT NULL,
                                                 `status` VARCHAR(45) NOT NULL,
                                                 `order_amount` INT NOT NULL,
                                                 PRIMARY KEY (`order_id`),
                                                 INDEX `fk_orders_User1_idx` (`user_id` ASC) VISIBLE,
                                                 CONSTRAINT `fk_orders_User1`
                                                     FOREIGN KEY (`user_id`)
                                                         REFERENCES `cupcake`.`user` (`user_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `cupcake`.`topping`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cupcake`.`topping` ;

CREATE TABLE IF NOT EXISTS `cupcake`.`topping` (
                                                   `topping_id` INT NOT NULL AUTO_INCREMENT,
                                                   `topping_name` VARCHAR(45) NOT NULL,
                                                   `topping_price` INT NOT NULL,
                                                   PRIMARY KEY (`topping_id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 10
    DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `cupcake`.`orderline`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cupcake`.`orderline` ;

CREATE TABLE IF NOT EXISTS `cupcake`.`orderline` (
                                                     `orderline_id` INT NOT NULL AUTO_INCREMENT,
                                                     `order_id` INT NOT NULL,
                                                     `quantity` INT NOT NULL,
                                                     `topping_id` INT NOT NULL,
                                                     `bottom_id` INT NOT NULL,
                                                     `price` INT NOT NULL,
                                                     PRIMARY KEY (`orderline_id`),
                                                     INDEX `fk_orderlines_topping_idx` (`topping_id` ASC) VISIBLE,
                                                     INDEX `fk_orderlines_bottom1_idx` (`bottom_id` ASC) VISIBLE,
                                                     INDEX `fk_orderlines_orders1_idx` (`order_id` ASC) VISIBLE,
                                                     CONSTRAINT `fk_orderlines_bottom1`
                                                         FOREIGN KEY (`bottom_id`)
                                                             REFERENCES `cupcake`.`bottom` (`bottom_id`),
                                                     CONSTRAINT `fk_orderlines_orders1`
                                                         FOREIGN KEY (`order_id`)
                                                             REFERENCES `cupcake`.`order` (`order_id`),
                                                     CONSTRAINT `fk_orderlines_topping`
                                                         FOREIGN KEY (`topping_id`)
                                                             REFERENCES `cupcake`.`topping` (`topping_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
