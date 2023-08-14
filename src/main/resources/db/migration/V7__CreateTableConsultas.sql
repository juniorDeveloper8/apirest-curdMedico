-- -----------------------------------------------------
-- Table `prueba`.`consultas`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `prueba`.`consultas` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `paciente_id` BIGINT NOT NULL,
  `medico_id` BIGINT NOT NULL,
  `data` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_consultas_medico_idx` (`medico_id` ASC) VISIBLE,
  INDEX `fk_consultas_paciente1_idx` (`paciente_id` ASC) VISIBLE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;