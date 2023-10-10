CREATE TABLE produtos(
    id bigint NOT NULL AUTO_INCREMENT,
    nome varchar(100) NOT NULL,
    descricao varchar(200) NOT NULL,
    cliente_id bigint  NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(cliente_id) references clientes(id)
    );
