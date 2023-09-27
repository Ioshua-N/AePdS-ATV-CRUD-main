create database Estoque;

use Estoque;

create table Produto (
id int primary key auto_increment not null,
nome varchar(25) not null,
preco float not null);

select * from Produto;

create table Logins
(
	id int primary key auto_increment not null,
    usuario varchar(25) not null,
    senha varchar(25) not null
);

select * from Logins;