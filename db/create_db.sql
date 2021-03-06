SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

SHOW WARNINGS;
DROP SCHEMA IF EXISTS `kicker` ;

CREATE SCHEMA IF NOT EXISTS `kicker` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `kicker` ;

DROP TABLE IF EXISTS `kicker`.`user_info` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `kicker`.`user_info` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `phone` VARCHAR(50) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `city` VARCHAR(100) NOT NULL,
  `delivery_method` VARCHAR(200) NOT NULL,
  `delivery_address` VARCHAR(200) NOT NULL,
  `version` INT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
