/**
 * Author:  Diego
 * Created: 23/06/2022
 */

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `psique_db` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `psique_db` ;

-- -----------------------------------------------------
-- Table `psique_db`.`Usuário`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `psique_db`.`Usuário` (
  `login_pk` VARCHAR(10) NOT NULL ,
  `senha` VARCHAR(45) NULL ,
  `cargo` VARCHAR(45) NULL ,
  PRIMARY KEY (`login_pk`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `psique_db`.`ADM`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `psique_db`.`ADM` (
  `loginADM` VARCHAR(10) NOT NULL ,
  `senha` VARCHAR(45) NOT NULL ,
  `cargo` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`loginADM`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `psique_db`.`Paciente`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `psique_db`.`Paciente` (
  `cpf` VARCHAR(11) NOT NULL ,
  `loginUsuario_FK` VARCHAR(45) NOT NULL ,
  `nome` VARCHAR(45) NOT NULL ,
  `telefone` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`cpf`) ,
  INDEX `loginUsuario_FK_idx` (`loginUsuario_FK` ASC) ,
  CONSTRAINT `loginUsuario_FK`
    FOREIGN KEY (`loginUsuario_FK` )
    REFERENCES `psique_db`.`Usuário` (`login_pk` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `psique_db`.`Endereco`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `psique_db`.`Endereco` (
  `rua` VARCHAR(45) NOT NULL ,
  `numero` INT NOT NULL ,
  `bairro` VARCHAR(45) NOT NULL ,
  `cidade` VARCHAR(45) NOT NULL ,
  `Estado` VARCHAR(45) NOT NULL ,
  `cpfPaciente_PK` VARCHAR(45) NULL ,
  PRIMARY KEY (`rua`) ,
  INDEX `cpfPaciente_PK_idx` (`cpfPaciente_PK` ASC) ,
  CONSTRAINT `cpfPaciente_PK`
    FOREIGN KEY (`cpfPaciente_PK` )
    REFERENCES `psique_db`.`Paciente` (`cpf` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `psique_db`.`Preco`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `psique_db`.`Preco` (
  `idPreco` INT NOT NULL ,
  `valorConsulta` FLOAT NOT NULL ,
  `nomePsicologo` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idPreco`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `psique_db`.`Consulta`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `psique_db`.`Consulta` (
  `idConsulta_PK` INT NOT NULL ,
  `cpfPaciente_FK` VARCHAR(45) NOT NULL ,
  `data` DATE NOT NULL ,
  `hora` TIME NOT NULL ,
  `sessão` INT NOT NULL ,
  `Preco_idPreco` INT NOT NULL ,
  PRIMARY KEY (`idConsulta_PK`) ,
  INDEX `cpfPaciente_FK_idx` (`cpfPaciente_FK` ASC) ,
  INDEX `fk_Consulta_Preco1_idx` (`Preco_idPreco` ASC) ,
  CONSTRAINT `cpfPaciente_FK`
    FOREIGN KEY (`cpfPaciente_FK` )
    REFERENCES `psique_db`.`Paciente` (`cpf` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Consulta_Preco1`
    FOREIGN KEY (`Preco_idPreco` )
    REFERENCES `psique_db`.`Preco` (`idPreco` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

