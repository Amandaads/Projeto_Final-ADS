package com.multidisciplinar.ProjetoFinal.DTO;

import java.util.UUID;

public record ResponseProfDTO(
            UUID id,
            String nome,
            String matricula,
            String cargo,
            String telefone
) {
}
