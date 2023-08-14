ALTER TABLE `prueba`.`medicos` 
ADD COLUMN `activo` tinyint AFTER `telefono`;
UPDATE `medicos` set activo = 1