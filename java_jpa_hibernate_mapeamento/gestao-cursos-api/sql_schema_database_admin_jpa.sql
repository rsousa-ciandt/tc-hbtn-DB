-- TABLE
CREATE TABLE alunos (id  integer, email varchar(255), matricula varchar(255), nascimento date, nomeCompleto varchar(255), primary key (id));
CREATE TABLE cursos (id  integer, nome varchar(255), sigla varchar(255), id_material bigint, id_professor bigint, primary key (id));
CREATE TABLE cursos_alunos (id_aluno bigint not null, id_curso bigint not null);
CREATE TABLE enderecos (id  integer, bairro varchar(255), cep integer, cidade varchar(255), endereco varchar(255), estado varchar(255), lougradouro varchar(255), numero varchar(255), id_endereco bigint, primary key (id));
CREATE TABLE materiais_cursos (id  integer, url varchar(255), primary key (id));
CREATE TABLE professores (id  integer, email varchar(255), matricula varchar(255), nomeCompleto varchar(255), primary key (id));
CREATE TABLE telefones (id  integer, DDD varchar(255), numero varchar(255), id_telefone bigint, primary key (id));
 
-- INDEX
 
-- TRIGGER
 
-- VIEW
 
