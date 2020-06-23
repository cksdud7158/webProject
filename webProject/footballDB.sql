-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema soccerproject
-- -----------------------------------------------------
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user` (
  `useId` VARCHAR(20) NOT NULL,
  `pass` VARCHAR(20) NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `phoneNum` VARCHAR(20) NOT NULL,
  `photo` VARCHAR(20) NULL,
  `ssn` VARCHAR(20) NOT NULL,
  `nickName` VARCHAR(20) NULL,
  `gender` CHAR(2) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `addr` VARCHAR(45) NOT NULL,
  `favTeam1` VARCHAR(45) NULL,
  `favTeam2` VARCHAR(45) NULL,
  `regDate` VARCHAR(20) NOT NULL,
  `country` DATE NULL,
  `recentLogin` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`useId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`playerInfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`playerInfo` (
  `user_useId` VARCHAR(20) NOT NULL,
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
  `playerIdcol` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_useId`),
  CONSTRAINT `fk_playerId_user`
    FOREIGN KEY (`user_useId`)
    REFERENCES `mydb`.`user` (`useId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`stadium`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`stadium` (
  `stadiumId` VARCHAR(20) NOT NULL,
  `stadiumName` VARCHAR(100) NOT NULL,
  `stadiumAddr` VARCHAR(100) NOT NULL,
  `stadiumCost` INT NOT NULL,
  `stadiumType` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`stadiumId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`team`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`team` (
  `teamId` VARCHAR(45) NOT NULL,
  `teamName` VARCHAR(45) NULL,
  `emblem` VARCHAR(45) NULL,
  `area1` VARCHAR(45) NULL,
  `area2` VARCHAR(45) NULL,
  `area3` VARCHAR(45) NULL,
  `stadiumId` VARCHAR(45) NULL,
  `stadium_stadiumId` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`teamId`),
  INDEX `fk_team_stadium1_idx` (`stadium_stadiumId` ASC) VISIBLE,
  CONSTRAINT `fk_team_stadium1`
    FOREIGN KEY (`stadium_stadiumId`)
    REFERENCES `mydb`.`stadium` (`stadiumId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`teamMember`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`teamMember` (
  `regDate` DATE NOT NULL,
  `manager` INT NOT NULL,
  `participation` DECIMAL(1) NOT NULL,
  `status` TINYINT NOT NULL,
  `user_useId` VARCHAR(20) NOT NULL,
  `team_teamId` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_useId`, `team_teamId`),
  INDEX `fk_teamMember_team1_idx` (`team_teamId` ASC) VISIBLE,
  CONSTRAINT `fk_teamMember_user1`
    FOREIGN KEY (`user_useId`)
    REFERENCES `mydb`.`user` (`useId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_teamMember_team1`
    FOREIGN KEY (`team_teamId`)
    REFERENCES `mydb`.`team` (`teamId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`match`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`match` (
  `matchId` VARCHAR(20) NOT NULL,
  `schedule` DATE NULL,
  `awayId` VARCHAR(45) NULL,
  `homeSquad` VARCHAR(200) NULL,
  `awaySquad` VARCHAR(200) NULL,
  `team_teamId` VARCHAR(45) NOT NULL,
  `stadium_stadiumId` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`matchId`),
  INDEX `fk_match_team1_idx` (`team_teamId` ASC) VISIBLE,
  INDEX `fk_match_stadium1_idx` (`stadium_stadiumId` ASC) VISIBLE,
  CONSTRAINT `fk_match_team1`
    FOREIGN KEY (`team_teamId`)
    REFERENCES `mydb`.`team` (`teamId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_match_stadium1`
    FOREIGN KEY (`stadium_stadiumId`)
    REFERENCES `mydb`.`stadium` (`stadiumId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`vote`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`vote` (
  `voteId` VARCHAR(20) NOT NULL,
  `attendence` VARCHAR(45) NOT NULL,
  `contents` VARCHAR(45) NULL,
  `dueDate` VARCHAR(45) NOT NULL,
  `teamMember_user_useId` VARCHAR(20) NOT NULL,
  `teamMember_team_teamId` INT NOT NULL,
  `team_teamId` VARCHAR(45) NOT NULL,
  `match_matchId` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`voteId`),
  INDEX `fk_vote_team1_idx` (`team_teamId` ASC) VISIBLE,
  INDEX `fk_vote_match1_idx` (`match_matchId` ASC) VISIBLE,
  CONSTRAINT `fk_vote_team1`
    FOREIGN KEY (`team_teamId`)
    REFERENCES `mydb`.`team` (`teamId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vote_match1`
    FOREIGN KEY (`match_matchId`)
    REFERENCES `mydb`.`match` (`matchId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`teamInfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`teamInfo` (
  `team_teamId` VARCHAR(45) NOT NULL,
  `mannerScore` INT NOT NULL,
  `matchNum` INT NOT NULL,
  `ranking` INT NOT NULL,
  `memberNum` INT NOT NULL,
  `teamScore` INT NOT NULL,
  `winningScore` INT NOT NULL,
  INDEX `fk_teamInfo_team1_idx` (`team_teamId` ASC) VISIBLE,
  CONSTRAINT `fk_teamInfo_team1`
    FOREIGN KEY (`team_teamId`)
    REFERENCES `mydb`.`team` (`teamId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`match_result`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`match_result` (
  `match_matchId` VARCHAR(20) NOT NULL,
  `score` INT NULL,
  `toAwayMannerScore` INT NULL,
  `toHomeMannerScore` INT NULL,
  INDEX `fk_match_result_match1_idx` (`match_matchId` ASC) VISIBLE,
  CONSTRAINT `fk_match_result_match1`
    FOREIGN KEY (`match_matchId`)
    REFERENCES `mydb`.`match` (`matchId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
