-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema soccerproject
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema soccerproject
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `soccerproject` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `soccerproject` ;

-- -----------------------------------------------------
-- Table `soccerproject`.`stadium`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `soccerproject`.`stadium` (
  `stadiumId` INT NOT NULL AUTO_INCREMENT,
  `stadiumName` VARCHAR(100) NOT NULL,
  `stadiumAddr` VARCHAR(100) NOT NULL,
  `stadiumCost` INT NOT NULL,
  `stadiumType` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`stadiumId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `soccerproject`.`team`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `soccerproject`.`team` (
  `teamId` INT NOT NULL AUTO_INCREMENT,
  `teamName` VARCHAR(45) NULL DEFAULT NULL,
  `emblem` VARCHAR(45) NULL DEFAULT NULL,
  `area1` VARCHAR(45) NULL DEFAULT NULL,
  `area2` VARCHAR(45) NULL DEFAULT NULL,
  `area3` VARCHAR(45) NULL DEFAULT NULL,
  `stadiumId` INT NOT NULL,
  PRIMARY KEY (`teamId`),
  INDEX `fk_team_stadium1_idx` (`stadiumId` ASC) VISIBLE,
  CONSTRAINT `fk_team_stadium1`
    FOREIGN KEY (`stadiumId`)
    REFERENCES `soccerproject`.`stadium` (`stadiumId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `soccerproject`.`vote`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `soccerproject`.`vote` (
  `voteId` INT NOT NULL AUTO_INCREMENT,
  `contents` VARCHAR(45) NULL DEFAULT NULL,
  `dueDate` DATE NOT NULL,
  `teamId` INT NOT NULL,
  `writer` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`voteId`),
  INDEX `fk_vote_team1_idx` (`teamId` ASC) VISIBLE,
  CONSTRAINT `fk_vote_team1`
    FOREIGN KEY (`teamId`)
    REFERENCES `soccerproject`.`team` (`teamId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `soccerproject`.`match`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `soccerproject`.`match` (
  `matchId` INT NOT NULL AUTO_INCREMENT,
  `schedule` DATE NULL DEFAULT NULL,
  `awayId` INT NULL DEFAULT NULL,
  `homeSquad` VARCHAR(200) NULL DEFAULT NULL,
  `awaySquad` VARCHAR(200) NULL DEFAULT NULL,
  `teamId` INT NOT NULL,
  `voteId` INT NOT NULL,
  `stadiumId` INT NOT NULL,
  PRIMARY KEY (`matchId`),
  INDEX `fk_match_team1_idx` (`teamId` ASC) VISIBLE,
  INDEX `fk_match_vote1_idx` (`voteId` ASC) VISIBLE,
  INDEX `fk_match_stadium1_idx` (`stadiumId` ASC) VISIBLE,
  CONSTRAINT `fk_match_team1`
    FOREIGN KEY (`teamId`)
    REFERENCES `soccerproject`.`team` (`teamId`)
	ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_match_vote1`
    FOREIGN KEY (`voteId`)
    REFERENCES `soccerproject`.`vote` (`voteId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_match_stadium1`
    FOREIGN KEY (`stadiumId`)
    REFERENCES `soccerproject`.`stadium` (`stadiumId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `soccerproject`.`match_result`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `soccerproject`.`match_result` (
  `score` VARCHAR(10) NULL DEFAULT NULL,
  `toAwayMannerScore` INT NULL DEFAULT NULL,
  `toHomeMannerScore` INT NULL DEFAULT NULL,
  `matchId` INT NOT NULL,
  PRIMARY KEY (`matchId`),
  CONSTRAINT `fk_match_result_match1`
    FOREIGN KEY (`matchId`)
    REFERENCES `soccerproject`.`match` (`matchId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `soccerproject`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `soccerproject`.`user` (
  `userId` VARCHAR(20) NOT NULL,
  `pass` VARCHAR(20) NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `phoneNum` VARCHAR(20) NOT NULL,
  `photo` VARCHAR(20) NULL DEFAULT NULL,
  `ssn` VARCHAR(20) NOT NULL,
  `nickName` VARCHAR(20) NULL DEFAULT NULL,
  `gender` CHAR(2) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `addr` VARCHAR(45) NOT NULL,
  `favTeam1` VARCHAR(45) NULL DEFAULT NULL,
  `favTeam2` VARCHAR(45) NULL DEFAULT NULL,
  `regDate` DATE NOT NULL,
  `country` VARCHAR(20) NULL DEFAULT NULL,
  `recentLogin` DATE NOT NULL,
  PRIMARY KEY (`userId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `soccerproject`.`playerinfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `soccerproject`.`playerinfo` (
  `userId` VARCHAR(20) NOT NULL,
  `position` VARCHAR(20) NOT NULL,
  `mainFoot` VARCHAR(45) NOT NULL,
  `height` INT NOT NULL,
  `weight` INT NOT NULL,
  `injury` INT NOT NULL,
  `mental` INT NOT NULL,
  `speed` INT NOT NULL,
  `physical` INT NOT NULL,
  `dribble` INT NOT NULL,
  `pass` INT NOT NULL,
  `defence` INT NOT NULL,
  `total` INT NOT NULL,
  PRIMARY KEY (`userId`),
  CONSTRAINT `fk_playerinfo_user`
    FOREIGN KEY (`userId`)
    REFERENCES `soccerproject`.`user` (`userId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `soccerproject`.`teaminfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `soccerproject`.`teaminfo` (
  `mannerScore` INT NOT NULL,
  `matchNum` INT NOT NULL,
  `ranking` INT NOT NULL,
  `memberNum` INT NOT NULL,
  `teamScore` INT NOT NULL,
  `winningScore` INT NOT NULL,
  `teamId` INT NOT NULL,
  PRIMARY KEY (`teamId`),
  CONSTRAINT `fk_teaminfo_team1`
    FOREIGN KEY (`teamId`)
    REFERENCES `soccerproject`.`team` (`teamId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `soccerproject`.`teammember`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `soccerproject`.`teammember` (
  `teammemberId` INT NOT NULL AUTO_INCREMENT,
  `regDate` DATE NOT NULL,
  `manager` INT NOT NULL,
  `participation` DECIMAL(1,0) NOT NULL,
  `status` TINYINT NOT NULL,
  `userId` VARCHAR(20) NOT NULL,
  `teamId` INT NOT NULL,
  PRIMARY KEY (`teammemberId`),
  INDEX `fk_teammember_user1_idx` (`userId` ASC) VISIBLE,
  INDEX `fk_teammember_team1_idx` (`teamId` ASC) VISIBLE,
  CONSTRAINT `fk_teammember_user1`
    FOREIGN KEY (`userId`)
    REFERENCES `soccerproject`.`user` (`userId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_teammember_team1`
    FOREIGN KEY (`teamId`)
    REFERENCES `soccerproject`.`team` (`teamId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `soccerproject`.`voteresult`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `soccerproject`.`voteresult` (
  `attendence` TINYINT NULL DEFAULT NULL,
  `voteId` INT NOT NULL,
  `teammemberId` INT NOT NULL,
  INDEX `fk_voteresult_vote1_idx` (`voteId` ASC) VISIBLE,
  INDEX `fk_voteresult_teammember1_idx` (`teammemberId` ASC) VISIBLE,
  CONSTRAINT `fk_voteresult_vote1`
    FOREIGN KEY (`voteId`)
    REFERENCES `soccerproject`.`vote` (`voteId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_voteresult_teammember1`
    FOREIGN KEY (`teammemberId`)
    REFERENCES `soccerproject`.`teammember` (`teammemberId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
