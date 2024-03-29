-- MySQL Script generated by MySQL Workbench
-- Thu Feb 15 21:43:39 2024
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema simple_board
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema simple_board
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `simple_board` DEFAULT CHARACTER SET utf8 ;
USE `simple_board` ;

-- -----------------------------------------------------
-- Table `simple_board`.`board`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `simple_board`.`board` (
  `id` BIGINT(32) NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `boardname` VARCHAR(100) NOT NULL,
  `status` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `simple_board`.`post`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `simple_board`.`post` (
  `id` BIGINT(32) NOT NULL,
  `board_id` BIGINT(32) NOT NULL,
  `user_name` VARCHAR(50) NOT NULL,
  `password` VARCHAR(4) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `status` VARCHAR(50) NOT NULL,
  `content` TEXT NULL,
  `posted_at` DATETIME NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `simple_board`.`reply`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `simple_board`.`reply` (
  `id` BIGINT(32) NOT NULL AUTO_INCREMENT,
  `post_id` BIGINT(32) NOT NULL,
  `user_name` VARCHAR(50) NOT NULL,
  `passowrd` VARCHAR(4) NOT NULL,
  `staus` VARCHAR(50) NOT NULL,
  `title` VARCHAR(100) NOT NULL,
  `content` TEXT NOT NULL,
  `reply_at` DATETIME NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
