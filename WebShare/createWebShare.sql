SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `WebShare` ;
CREATE SCHEMA IF NOT EXISTS `WebShare` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `WebShare` ;

-- -----------------------------------------------------
-- Table `WebShare`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `WebShare`.`user` ;

CREATE  TABLE IF NOT EXISTS `WebShare`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `firstname` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(45) NOT NULL ,
  `lastname` VARCHAR(45) NOT NULL ,
  `email` VARCHAR(45) NOT NULL ,
  `deleted` TINYINT(1) NOT NULL ,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `WebShare`.`file`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `WebShare`.`file` ;

CREATE  TABLE IF NOT EXISTS `WebShare`.`file` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `public` TINYINT(1) NOT NULL ,
  `path` VARCHAR(255) NOT NULL ,
  `isDir` TINYINT(1) NOT NULL ,
  `deleted` TINYINT(1) NOT NULL ,
  `parent_id` INT NOT NULL,
  PRIMARY KEY (`id`, `parent_id`) ,
  UNIQUE INDEX `path_UNIQUE` (`path` ASC) ,
  INDEX `fk_file_file1` (`parent_id` ASC) ,
  CONSTRAINT `fk_file_file1`
    FOREIGN KEY (`parent_id` )
    REFERENCES `WebShare`.`file` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `WebShare`.`event`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `WebShare`.`event` ;

CREATE  TABLE IF NOT EXISTS `WebShare`.`event` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `action` INT NULL ,
  `user_id` INT NOT NULL ,
  `file_id` INT NOT NULL ,
  `date` DATETIME NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Event_User1` (`user_id` ASC) ,
  INDEX `fk_event_file1` (`file_id` ASC) ,
  CONSTRAINT `fk_Event_User1`
    FOREIGN KEY (`user_id` )
    REFERENCES `WebShare`.`user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_event_file1`
    FOREIGN KEY (`file_id` )
    REFERENCES `WebShare`.`file` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `WebShare`.`user_has_right_to_file`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `WebShare`.`user_has_right_to_file` ;

CREATE  TABLE IF NOT EXISTS `WebShare`.`user_has_right_to_file` (
  `user_id` INT NOT NULL ,
  `file_id` INT NOT NULL ,
  `state` TINYINT(1) NOT NULL ,
  PRIMARY KEY (`user_id`, `file_id`) ,
  INDEX `fk_User_has_File_File1` (`file_id` ASC) ,
  INDEX `fk_User_has_File_User` (`user_id` ASC) ,
  CONSTRAINT `fk_User_has_File_User`
    FOREIGN KEY (`user_id` )
    REFERENCES `WebShare`.`user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_File_File1`
    FOREIGN KEY (`file_id` )
    REFERENCES `WebShare`.`file` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
