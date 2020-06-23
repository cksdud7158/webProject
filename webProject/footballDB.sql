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

-- -----------------------------------------------------
-- Schema soccerproject
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `soccerproject` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `mydb` ;
USE `soccerproject` ;

-- -----------------------------------------------------
-- Table `soccerproject`.`stadium`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `soccerproject`.`stadium` (
  `stadiumId` VARCHAR(20) NOT NULL,
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
  `teamId` VARCHAR(45) NOT NULL,
  `teamName` VARCHAR(45) NULL DEFAULT NULL,
  `emblem` VARCHAR(45) NULL DEFAULT NULL,
  `area1` VARCHAR(45) NULL DEFAULT NULL,
  `area2` VARCHAR(45) NULL DEFAULT NULL,
  `area3` VARCHAR(45) NULL DEFAULT NULL,
  `stadiumId` VARCHAR(45) NULL DEFAULT NULL,
  `stadium_stadiumId` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`teamId`),
  INDEX `fk_team_stadium1_idx` (`stadium_stadiumId` ASC) VISIBLE,
  CONSTRAINT `fk_team_stadium1`
    FOREIGN KEY (`stadium_stadiumId`)
    REFERENCES `soccerproject`.`stadium` (`stadiumId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `soccerproject`.`match`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `soccerproject`.`match` (
  `matchId` VARCHAR(20) NOT NULL,
  `schedule` DATE NULL DEFAULT NULL,
  `awayId` VARCHAR(45) NULL DEFAULT NULL,
  `homeSquad` VARCHAR(200) NULL DEFAULT NULL,
  `awaySquad` VARCHAR(200) NULL DEFAULT NULL,
  `team_teamId` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`matchId`, `team_teamId`),
  INDEX `fk_match_team1_idx` (`team_teamId` ASC) VISIBLE,
  CONSTRAINT `fk_match_team1`
    FOREIGN KEY (`team_teamId`)
    REFERENCES `soccerproject`.`team` (`teamId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `soccerproject`.`match_result`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `soccerproject`.`match_result` (
  `score` INT NULL DEFAULT NULL,
  `toAwayMannerScore` INT NULL DEFAULT NULL,
  `toHomeMannerScore` INT NULL DEFAULT NULL,
  `match_matchId` VARCHAR(20) NOT NULL,
  `match_team_teamId` VARCHAR(45) NOT NULL,
  INDEX `fk_match_result_match1_idx` (`match_matchId` ASC, `match_team_teamId` ASC) VISIBLE,
  CONSTRAINT `fk_match_result_match1`
    FOREIGN KEY (`match_matchId` , `match_team_teamId`)
    REFERENCES `soccerproject`.`match` (`matchId` , `team_teamId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `soccerproject`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `soccerproject`.`user` (
  `useId` VARCHAR(20) NOT NULL,
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
  `regDate` VARCHAR(20) NOT NULL,
  `country` DATE NULL DEFAULT NULL,
  `recentLogin` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`useId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `soccerproject`.`playerinfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `soccerproject`.`playerinfo` (
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
  CONSTRAINT `fk_playerinfo_user`
    FOREIGN KEY (`user_useId`)
    REFERENCES `soccerproject`.`user` (`useId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
  `team_teamId` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`team_teamId`),
  CONSTRAINT `fk_teaminfo_team1`
    FOREIGN KEY (`team_teamId`)
    REFERENCES `soccerproject`.`team` (`teamId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `soccerproject`.`teammember`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `soccerproject`.`teammember` (
  `regDate` DATE NOT NULL,
  `manager` INT NOT NULL,
  `participation` DECIMAL(1,0) NOT NULL,
  `status` TINYINT NOT NULL,
  `user_useId` VARCHAR(20) NOT NULL,
  `team_teamId` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_useId`, `team_teamId`),
  INDEX `fk_teammember_team1_idx` (`team_teamId` ASC) VISIBLE,
  CONSTRAINT `fk_teammember_user1`
    FOREIGN KEY (`user_useId`)
    REFERENCES `soccerproject`.`user` (`useId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_teammember_team1`
    FOREIGN KEY (`team_teamId`)
    REFERENCES `soccerproject`.`team` (`teamId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `soccerproject`.`vote`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `soccerproject`.`vote` (
  `voteId` VARCHAR(20) NOT NULL,
  `attendence` VARCHAR(45) NOT NULL,
  `contents` VARCHAR(45) NULL DEFAULT NULL,
  `dueDate` VARCHAR(45) NOT NULL,
  `teamMember_user_useId` VARCHAR(20) NOT NULL,
  `teamMember_team_teamId` INT NOT NULL,
  `teammember_user_useId` VARCHAR(20) NOT NULL,
  `teammember_team_teamId` VARCHAR(45) NOT NULL,
  `team_teamId` VARCHAR(45) NOT NULL,
  `match_matchId` VARCHAR(20) NOT NULL,
  `match_team_teamId` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`voteId`),
  INDEX `fk_vote_teammember1_idx` (`teammember_user_useId` ASC, `teammember_team_teamId` ASC) VISIBLE,
  INDEX `fk_vote_team1_idx` (`team_teamId` ASC) VISIBLE,
  INDEX `fk_vote_match1_idx` (`match_matchId` ASC, `match_team_teamId` ASC) VISIBLE,
  CONSTRAINT `fk_vote_teammember1`
    FOREIGN KEY (`teammember_user_useId` , `teammember_team_teamId`)
    REFERENCES `soccerproject`.`teammember` (`user_useId` , `team_teamId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vote_team1`
    FOREIGN KEY (`team_teamId`)
    REFERENCES `soccerproject`.`team` (`teamId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vote_match1`
    FOREIGN KEY (`match_matchId` , `match_team_teamId`)
    REFERENCES `soccerproject`.`match` (`matchId` , `team_teamId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
