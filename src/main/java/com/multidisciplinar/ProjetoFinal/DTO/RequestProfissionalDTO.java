package com.multidisciplinar.ProjetoFinal.DTO;

public record RequestProfissionalDTO(
        String nome,
        String matricula,
        String cargo,
        String telefone,
        String email,
        String senha
) {
}
