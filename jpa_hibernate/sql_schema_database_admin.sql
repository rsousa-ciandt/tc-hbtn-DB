-- TABLE
CREATE TABLE hibernate_sequence (next_val bigint);
CREATE TABLE Pessoa (id  integer, cpf varchar(255), dataNascimento date, email varchar(255), idade integer, nome varchar(255), primary key (id));
CREATE TABLE Produto (id bigint not null, nome varchar(255), preco double precision, quantidade integer, status boolean, primary key (id));
 
-- INDEX
 
-- TRIGGER
 
-- VIEW
 
