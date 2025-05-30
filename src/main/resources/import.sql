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

INSERT INTO tb_animal (idade, sexo, raca_fk, categoria_fk, peso) VALUES (3, 'M', 2, 2, 50);
INSERT INTO tb_animal (idade, sexo, raca_fk, categoria_fk, peso) VALUES (1, 'M', 2, 2, 60);
INSERT INTO tb_animal (idade, sexo, raca_fk, categoria_fk, peso) VALUES (4, 'M', 3, 3, 70);
INSERT INTO tb_animal (idade, sexo, raca_fk, categoria_fk, peso) VALUES (5, 'F', 4, 2, 80);
INSERT INTO tb_animal (idade, sexo, raca_fk, categoria_fk, peso) VALUES (6, 'F', 5, 1, 90);

INSERT INTO tb_vacina (vacina) VALUES ('Raiva');
INSERT INTO tb_vacina (vacina) VALUES ('Frebe Aftosa');

INSERT INTO tb_animal_vacina(animal_id, vacina_id, data_aplicacao) VALUES (1, 1, '2025-03-25');
INSERT INTO tb_animal_vacina(animal_id, vacina_id, data_aplicacao) VALUES (1, 2, '2024-02-14');
INSERT INTO tb_animal_vacina(animal_id, vacina_id, data_aplicacao) VALUES (2, 1, '2023-07-13');
INSERT INTO tb_animal_vacina(animal_id, vacina_id, data_aplicacao) VALUES (3, 2, '2023-07-19');
