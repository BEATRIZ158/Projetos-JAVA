/*Alteração do banco*/

ALTER TABLE cliente
ADD COLUMN status varchar(1)
ADD COLUMN cidade integer;

ALTER TABLE cliente
ADD CONSTRAINT fk_cidade
FOREIGN KEY (cidade)
REFERENCES cidade(idcidade);
