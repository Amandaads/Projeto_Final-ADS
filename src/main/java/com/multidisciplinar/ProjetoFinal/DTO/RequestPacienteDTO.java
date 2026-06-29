package com.multidisciplinar.ProjetoFinal.DTO;

public record RequestPacienteDTO(
        String nome,
        String cpf,
        String telefone,
        String nascimento,
        String endereco,
        String email,
        String senha
) {


}
