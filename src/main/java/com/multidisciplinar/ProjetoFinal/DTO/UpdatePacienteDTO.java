package com.multidisciplinar.ProjetoFinal.DTO;

public record UpdatePacienteDTO(
        String nome,
        String telefone,
        String nascimento,
        String endereco
) {
}
