CREATE TABLE consulta
(
    id            SERIAL PRIMARY KEY,
    medico_id     BIGINT    NOT NULL,
    paciente_id   BIGINT    NOT NULL,
    data_consulta TIMESTAMP NOT NULL,
    FOREIGN KEY (medico_id) REFERENCES medico (id),
    FOREIGN KEY (paciente_id) REFERENCES paciente (id)
);
