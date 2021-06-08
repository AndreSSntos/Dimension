create database dimension;
use dimension;
create table empresa (idCliente int primary key auto_increment,
						nomeCliente varchar(45),
                        emailCliente varchar(45),
                        cnpjCliente char (14),
                        cep char(8),
                        telefoneCliente char(12));
create table funcionarios (idFuncionario int primary key auto_increment,
							nomeFuncionario varchar(45),
                            loginFuncionario varchar(45),
                            senhaFuncionario varchar(45),
                            fkCliente int);
create table maquinas (idMaquinas int primary key auto_increment,
						fkCliente int,
                        versaoSO varchar(45),
                        modeloMaquina varchar(45));
create table maquinasFuncionarios(fkmaquina int,
								fkfuncionario int);
create table componentes (idComponentes int primary key,
							nomeComponente varchar(45));
create table maquinasComponentes (fkMaquinas int,
									fkComponentes int,
                                    especificacoesComponentes  varchar(45));
create table registro ( idRegistro int primary key auto_increment,
						nomeComponente varchar(100),
						data datetime,
                        dadosColetados double(100,5));
                        
select * from registro;
drop table registro;