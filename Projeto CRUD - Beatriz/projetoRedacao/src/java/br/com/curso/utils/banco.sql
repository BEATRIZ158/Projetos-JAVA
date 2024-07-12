create table escola(
    idescola serial primary key,
    nomeescola varchar(100) not null,
    endereco varchar(100) not null,
    telefone varchar(20) not null
);

insert into escola(nomeescola,endereco, telefone) values('Escola Estadual Prefeito José Ribeiro', 'Avenida Antônio Carlos', '(17)99443-1146');
select * from escola;

create table aluno(
    idaluno serial primary key,
    nomealuno varchar(100) not null,
    serie integer not null,
    idescola integer not null,
    emailaluno varchar(100) not null,
    constraint fk_escola foreign key(idescola) references escola(idescola)
);

insert into aluno(nomealuno, serie, idescola, emailaluno) values('Vaucir Carrasco', 1, 1, 'vaucircarrasco134@gmail.com');
select * from aluno;
