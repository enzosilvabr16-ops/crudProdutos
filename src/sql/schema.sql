--Script pra criar uma tabela de produtos.
CREATE TABLE produtos(
    id                    SERIAL               PRIMARY KEY,
    nome                  VARCHAR(100)         NOT NULL,
    preco                 DECIMAL(10,2)        NOT NULL,
    quantidade            INT                  NOT NULL,
    datahoracadastro      TIMESTAMP            DEFAULT CURRENT_TIMESTAMP
);