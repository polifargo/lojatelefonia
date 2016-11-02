CREATE TABLE clientes
(
id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
nome VARCHAR(255),
nascimento VARCHAR(12),
telefone varchar(30),
cpf varchar(11),
CONSTRAINT primary_key PRIMARY KEY (id)
) ;

CREATE TABLE produtos
(
id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
nome VARCHAR(255),
descricao VARCHAR(255),
marca varchar(50),
serie varchar(5),
fabricacao varchar(12),
qtd integer,
valor double,
PRIMARY KEY (id)
) ;

CREATE TABLE venda 
(
id_venda INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
valor_fk double,
produto_fk VARCHAR(255),
qtd_fk integer,
PRIMARY KEY (id_venda)
) ;