package com.multidisciplinar.ProjetoFinal.DTO;

import com.multidisciplinar.ProjetoFinal.Domain.TipoUsuario;

import java.util.UUID;

public record ResponseUserDTO(UUID id, String email, TipoUsuario tipoUsuario) {

}
