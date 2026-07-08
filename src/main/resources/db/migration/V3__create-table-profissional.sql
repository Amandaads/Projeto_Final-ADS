CREATE TABLE PROFISSIONAL (
    id UUID PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    matricula VARCHAR(20) NOT NULL UNIQUE,
    cargo VARCHAR(100) NOT NULL,
    telefone VARCHAR(15) NOT NULL,
    usuario_id UUID NOT NULL,

    CONSTRAINT fk_profissional_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE CASCADE
);