create database agencia;

use agencia;

create table passeio(
	idPasseio int auto_increment primary key,
    descPasseio varchar(100),
    localPasseio varchar(15),
    idPacote int not null,
    foreign key (idPacote) references pacote (idPacote) 
    );

create table pacote(
	idPacote int not null auto_increment primary key,
    descPacote varchar(100),
    dataEmbarque date not null,
    dataRetorno date not null,
    custo double not null
	);
    
create table passeioPacote(
	idPacote int not null,
    idPasseio int not null,
    foreign key (idPacote) references pacote(idPacote),
    foreign key (idPasseio) references passeio(idPasseio),
    primary key(idPacote,idPasseio)
	);

