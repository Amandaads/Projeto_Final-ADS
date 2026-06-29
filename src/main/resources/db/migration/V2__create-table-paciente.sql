CREATE TABLE paciente(
    id UUID PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    telefone VARCHAR(15) NOT NULL,
    nascimento VARCHAR NOT NULL,
    endereco VARCHAR(150),
    usuario_id UUID NOT NULL,

    CONSTRAINT fk_paciente_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE CASCADE

);