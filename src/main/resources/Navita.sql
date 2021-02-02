create database navita;
use navita;

-- criar a database, iniciar a aplicação e popular o banco com a massa


insert into cliente (nome, email, senha) values ("Renato", "renato@email.com","123");
insert into cliente (nome, email, senha) values ("Livia", "Livia@email.com","123");

insert into marca (nome) values ("Xiaomi");
insert into marca (nome) values ("Samsung");

insert into patrimonio (nome, descricao,tombo, id_marca) 
values("celular","aparelho telefonico",1,(select id from Marca where nome='Xiaomi'));
insert into patrimonio (nome, descricao,tombo, id_marca) 
values("TV","aparelho de televisao",2,(select id from Marca where nome='Samsung'));



  