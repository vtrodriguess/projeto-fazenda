INSERT INTO tb_categoria (categoria) VALUES ('Cria')
INSERT INTO tb_categoria (categoria) VALUES ('Recria')
INSERT INTO tb_categoria (categoria) VALUES ('Engorda')
INSERT INTO tb_categoria (categoria) VALUES ('Terminação')

INSERT INTO tb_raca (raca, tipo) VALUES ('Angus', 'Taurino');
INSERT INTO tb_raca (raca, tipo) VALUES ('Brahman', 'Zebuíno');
INSERT INTO tb_raca (raca, tipo) VALUES ('Gir', 'Zebuíno');
INSERT INTO tb_raca (raca, tipo) VALUES ('Nelore', 'Zebuíno');
INSERT INTO tb_raca (raca, tipo) VALUES ('Senepol', 'Sintético');
INSERT INTO tb_raca (raca, tipo) VALUES ('Sindi', 'Zebuíno');

INSERT INTO tb_animal (idade, sexo, raca_fk, categoria_fk, peso) VALUES (3, 'M', 2, 2, 50)

INSERT INTO tb_vacina (vacina, animal_fk) VALUES ('Raiva', 1)

