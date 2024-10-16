CREATE TABLE IF NOT EXISTS endereco
(
    id          SERIAL PRIMARY KEY,
    logradoura  VARCHAR(255) NOT NULL,
    bairro      VARCHAR(100) NOT NULL,
    cep         VARCHAR(10)  NOT NULL,
    cidade      VARCHAR(100) NOT NULL,
    uf          CHAR(2)      NOT NULL,
    complemento VARCHAR(255),
    numero      VARCHAR(10)  NOT NULL
);

CREATE TABLE IF NOT EXISTS medico
(
    id            SERIAL PRIMARY KEY,
    nome          VARCHAR(255) NOT NULL,
    email         VARCHAR(255) NOT NULL UNIQUE,
    crm           VARCHAR(20)  NOT NULL,
    especialidade VARCHAR(50)  NOT NULL,
    endereco_id   BIGINT,
    FOREIGN KEY (endereco_id) REFERENCES endereco (id) ON DELETE CASCADE
);

