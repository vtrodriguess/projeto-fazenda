INSERT INTO tb_categoria (categoria) VALUES ('Cria');
INSERT INTO tb_categoria (categoria) VALUES ('Recria');
INSERT INTO tb_categoria (categoria) VALUES ('Engorda');
INSERT INTO tb_categoria (categoria) VALUES ('Terminação');

INSERT INTO tb_raca (raca, tipo) VALUES ('Angus', 'Taurino');
INSERT INTO tb_raca (raca, tipo) VALUES ('Brahman', 'Zebuíno');
INSERT INTO tb_raca (raca, tipo) VALUES ('Gir', 'Zebuíno');
INSERT INTO tb_raca (raca, tipo) VALUES ('Nelore', 'Zebuíno');
INSERT INTO tb_raca (raca, tipo) VALUES ('Senepol', 'Sintético');
INSERT INTO tb_raca (raca, tipo) VALUES ('Sindi', 'Zebuíno');

INSERT INTO tb_animal (meses, sexo, raca_fk, categoria_fk, peso) VALUES (15, 'M', 2, 2, 500);
INSERT INTO tb_animal (meses, sexo, raca_fk, categoria_fk, peso) VALUES (13, 'M', 2, 2, 450);
INSERT INTO tb_animal (meses, sexo, raca_fk, categoria_fk, peso) VALUES (12, 'M', 3, 3, 400);
INSERT INTO tb_animal (meses, sexo, raca_fk, categoria_fk, peso) VALUES (20, 'F', 4, 2, 450);
INSERT INTO tb_animal (meses, sexo, raca_fk, categoria_fk, peso) VALUES (21, 'F', 5, 1, 600);

INSERT INTO tb_vacina (vacina) VALUES ('Raiva');
INSERT INTO tb_vacina (vacina) VALUES ('Febre Aftosa');

INSERT INTO tb_animal_vacina(animal_id, vacina_id, data_aplicacao) VALUES (1, 1, '2025-03-25');
INSERT INTO tb_animal_vacina(animal_id, vacina_id, data_aplicacao) VALUES (1, 2, '2024-02-14');
INSERT INTO tb_animal_vacina(animal_id, vacina_id, data_aplicacao) VALUES (2, 1, '2023-07-13');
INSERT INTO tb_animal_vacina(animal_id, vacina_id, data_aplicacao) VALUES (3, 2, '2023-07-19');
