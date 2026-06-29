CREATE EXTENSION IF NOT EXISTS "pgcrypto";
CREATE TABLE usuario(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    email VARCHAR(255) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    tipo_usuario VARCHAR(50) NOT NULL,

    CONSTRAINT r_tipo_usuario CHECK (tipo_usuario IN ('ADMIN', 'PROFISSIONAL', 'PACIENTE'))

)