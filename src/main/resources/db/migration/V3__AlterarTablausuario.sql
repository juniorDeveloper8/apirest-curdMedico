-- Agrego un nuevo campo

ALTER TABLE `prueba`.`usuarios` 
ADD COLUMN `activo` tinyint AFTER `clave`;
UPDATE `usuarios` set activo = 1