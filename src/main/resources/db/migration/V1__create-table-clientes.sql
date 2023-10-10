CREATE TABLE clientes(

    id bigint NOT NULL AUTO_INCREMENT,
    nome varchar(100) NOT NULL,
    email varchar(100) NOT NULL UNIQUE,
    cpf varchar(14) NOT NULL UNIQUE,
    telefone varchar(20) NOT NULL,
    cep varchar(9) NOT NULL,
    logradouro varchar(100) NOT NULL,
    complemento varchar(100),
    bairro varchar(100) NOT NULL,
    localidade varchar(100) NOT NULL,
    uf char(2) NOT NULL,
    PRIMARY KEY(id)
);



