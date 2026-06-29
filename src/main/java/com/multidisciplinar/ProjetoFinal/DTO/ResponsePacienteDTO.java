package com.multidisciplinar.ProjetoFinal.DTO;

import java.util.UUID;

public record ResponsePacienteDTO(
        UUID id, String nome, String telefone, String endereco, String nascimento

) {
}
