CREATE TABLE IF NOT EXISTS paciente
(
    id               SERIAL PRIMARY KEY,
    nome             VARCHAR(255) NOT NULL,
    email            VARCHAR(255) NOT NULL UNIQUE,
    telefone         VARCHAR(20) NOT NULL,
    is_active_paciente BOOLEAN,
    endereco_id      BIGINT,
    FOREIGN KEY (endereco_id) REFERENCES endereco(id) ON DELETE CASCADE
    );
