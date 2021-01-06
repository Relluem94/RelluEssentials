-- MySQL Script generated by MySQL Workbench
-- Di 05 Jan 2021 22:02:21 CET
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema rellu_essentials
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema rellu_essentials
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `rellu_essentials` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;
USE `rellu_essentials` ;

-- -----------------------------------------------------
-- Table `rellu_essentials`.`group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rellu_essentials`.`group` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `prefix` VARCHAR(2) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rellu_essentials`.`player`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rellu_essentials`.`player` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `created` DATETIME NOT NULL,
  `createdby` INT NOT NULL,
  `updated` DATETIME NULL,
  `updatedby` INT NULL,
  `deleted` DATETIME NULL,
  `deletedby` INT NULL,
  `uuid` VARCHAR(45) NOT NULL,
  `group_fk` INT(21) NOT NULL,
  `afk` TINYINT NULL DEFAULT 0,
  `fly` TINYINT NULL DEFAULT 0,
  `customname` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_player_group_1_idx` (`group_fk` ASC),
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC),
  CONSTRAINT `fk_player_group_1`
    FOREIGN KEY (`group_fk`)
    REFERENCES `rellu_essentials`.`group` (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rellu_essentials`.`location_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rellu_essentials`.`location_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `location_type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rellu_essentials`.`location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rellu_essentials`.`location` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `created` DATETIME NOT NULL,
  `createdby` INT NOT NULL,
  `deleted` DATETIME NULL,
  `deletedby` INT NULL,
  `x` FLOAT NOT NULL,
  `y` FLOAT NOT NULL,
  `z` FLOAT NOT NULL,
  `yaw` FLOAT NOT NULL,
  `pitch` FLOAT NOT NULL,
  `world` VARCHAR(45) NOT NULL,
  `location_name` VARCHAR(45) NULL,
  `location_type_fk` INT NOT NULL,
  `player_fk` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_location_type_1_idx` (`location_type_fk` ASC),
  INDEX `fk_location_player_1_idx` (`player_fk` ASC),
  CONSTRAINT `fk_location_type_1`
    FOREIGN KEY (`location_type_fk`)
    REFERENCES `rellu_essentials`.`location_type` (`id`),
  CONSTRAINT `fk_location_player_1`
    FOREIGN KEY (`player_fk`)
    REFERENCES `rellu_essentials`.`player` (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rellu_essentials`.`block_history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rellu_essentials`.`block_history` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `CREATED` DATETIME NOT NULL,
  `CREATEDBY` INT NOT NULL,
  `UPDATED` DATETIME NULL,
  `UPDATEDBY` INT NULL,
  `DELETED` DATETIME NULL,
  `DELETEDBY` INT NULL,
  `location_fk` INT NOT NULL,
  `player_fk` INT NOT NULL,
  `material` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`ID`, `location_fk`, `player_fk`, `material`),
  INDEX `fk_block_history_1_idx` (`location_fk` ASC),
  INDEX `fk_block_history_2_idx` (`player_fk` ASC),
  CONSTRAINT `fk_block_history_1`
    FOREIGN KEY (`location_fk`)
    REFERENCES `rellu_essentials`.`location` (`id`),
  CONSTRAINT `fk_block_history_2`
    FOREIGN KEY (`player_fk`)
    REFERENCES `rellu_essentials`.`player` (`id`));


-- -----------------------------------------------------
-- Table `rellu_essentials`.`plugin_informations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rellu_essentials`.`plugin_informations` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `CREATED` DATETIME NOT NULL,
  `CREATEDBY` INT NOT NULL,
  `UPDATED` DATETIME NULL,
  `UPDATEDBY` INT NULL,
  `DELETED` DATETIME NULL,
  `DELETEDBY` INT NULL,
  `tab_header` VARCHAR(255) NOT NULL,
  `tab_footer` VARCHAR(255) NOT NULL,
  `motd_message` VARCHAR(255) NOT NULL,
  `motd_players` INT NOT NULL,
  `db_version` INT NOT NULL,
  PRIMARY KEY (`ID`));


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `rellu_essentials`.`group`
-- -----------------------------------------------------
START TRANSACTION;
USE `rellu_essentials`;
INSERT INTO `rellu_essentials`.`group` (`id`, `name`, `prefix`) VALUES (1, 'User', '§8');
INSERT INTO `rellu_essentials`.`group` (`id`, `name`, `prefix`) VALUES (2, 'VIP', '§a');
INSERT INTO `rellu_essentials`.`group` (`id`, `name`, `prefix`) VALUES (4, 'Mod', '§6');
INSERT INTO `rellu_essentials`.`group` (`id`, `name`, `prefix`) VALUES (8, 'Admin', '§5');

COMMIT;


-- -----------------------------------------------------
-- Data for table `rellu_essentials`.`player`
-- -----------------------------------------------------
START TRANSACTION;
USE `rellu_essentials`;
INSERT INTO `rellu_essentials`.`player` (`id`, `created`, `createdby`, `updated`, `updatedby`, `deleted`, `deletedby`, `uuid`, `group_fk`, `afk`, `fly`, `customname`) VALUES (1, '2021-01-05 20:57:05', 1, NULL, NULL, NULL, NULL, '', 8, 0, 0, 'CONSOLE');

COMMIT;


-- -----------------------------------------------------
-- Data for table `rellu_essentials`.`location_type`
-- -----------------------------------------------------
START TRANSACTION;
USE `rellu_essentials`;
INSERT INTO `rellu_essentials`.`location_type` (`id`, `location_type`) VALUES (1, 'home');
INSERT INTO `rellu_essentials`.`location_type` (`id`, `location_type`) VALUES (2, 'death');
INSERT INTO `rellu_essentials`.`location_type` (`id`, `location_type`) VALUES (3, 'warp');
INSERT INTO `rellu_essentials`.`location_type` (`id`, `location_type`) VALUES (4, 'block_history');

COMMIT;

