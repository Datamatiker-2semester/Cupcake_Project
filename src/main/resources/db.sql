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
    AUTO_INCREMENT = 11
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
    AUTO_INCREMENT = 24
    DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `cupcake`.`order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cupcake`.`order` ;

CREATE TABLE IF NOT EXISTS `cupcake`.`order` (
                                                 `order_id` INT NOT NULL AUTO_INCREMENT,
                                                 `user_id` INT NOT NULL,
                                                 PRIMARY KEY (`order_id`),
                                                 INDEX `fk_orders_User1_idx` (`user_id` ASC) VISIBLE,
                                                 CONSTRAINT `fk_orders_User1`
                                                     FOREIGN KEY (`user_id`)
                                                         REFERENCES `cupcake`.`user` (`user_id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 2
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
    AUTO_INCREMENT = 19
    DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `cupcake`.`orderline`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cupcake`.`orderline` ;

CREATE TABLE IF NOT EXISTS `cupcake`.`orderline` (
                                                     `order_id` INT NOT NULL AUTO_INCREMENT,
                                                     `topping_id` INT NOT NULL,
                                                     `bottom_id` INT NOT NULL,
                                                     `cupcake_price` INT NOT NULL,
                                                     PRIMARY KEY (`order_id`),
                                                     INDEX `fk_orderline_topping1_idx` (`topping_id` ASC) VISIBLE,
                                                     INDEX `fk_orderline_bottom1_idx` (`bottom_id` ASC) VISIBLE,
                                                     CONSTRAINT `fk_orderline_bottom1`
                                                         FOREIGN KEY (`bottom_id`)
                                                             REFERENCES `cupcake`.`bottom` (`bottom_id`),
                                                     CONSTRAINT `fk_orderline_order1`
                                                         FOREIGN KEY (`order_id`)
                                                             REFERENCES `cupcake`.`order` (`order_id`),
                                                     CONSTRAINT `fk_orderline_topping1`
                                                         FOREIGN KEY (`topping_id`)
                                                             REFERENCES `cupcake`.`topping` (`topping_id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 2
    DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
INSERT INTO `cupcake`.`topping` (`topping_name`, `topping_price`) VALUES ('Chocolate', '5');
INSERT INTO `cupcake`.`topping` (`topping_name`, `topping_price`) VALUES ('Blueberry', '5');
INSERT INTO `cupcake`.`topping` (`topping_name`, `topping_price`) VALUES ('Rasberry', '5');
INSERT INTO `cupcake`.`topping` (`topping_name`, `topping_price`) VALUES ('Crispy', '6');
INSERT INTO `cupcake`.`topping` (`topping_name`, `topping_price`) VALUES ('Strawberry', '6');
INSERT INTO `cupcake`.`topping` (`topping_name`, `topping_price`) VALUES ('Rum/Raisin', '7');
INSERT INTO `cupcake`.`topping` (`topping_name`, `topping_price`) VALUES ('Orange', '8');
INSERT INTO `cupcake`.`topping` (`topping_name`, `topping_price`) VALUES ('Lemon', '8');
INSERT INTO `cupcake`.`topping` (`topping_name`, `topping_price`) VALUES ('Blue cheese', '9');

INSERT INTO `cupcake`.`bottom` (`bottom_name`, `bottom_price`) VALUES ('Chocolate', '5');
INSERT INTO `cupcake`.`bottom` (`bottom_name`, `bottom_price`) VALUES ('Vanilla', '5');
INSERT INTO `cupcake`.`bottom` (`bottom_name`, `bottom_price`) VALUES ('Nutmeg', '5');
INSERT INTO `cupcake`.`bottom` (`bottom_name`, `bottom_price`) VALUES ('Pistacio', '6');
INSERT INTO `cupcake`.`bottom` (`bottom_name`, `bottom_price`) VALUES ('Almond', '7');