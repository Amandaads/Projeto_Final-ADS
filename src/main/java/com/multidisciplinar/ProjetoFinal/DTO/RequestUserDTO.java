package com.multidisciplinar.ProjetoFinal.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record RequestUserDTO(
        UUID id,

        @NotBlank(message = "O email é obrigatorio")
        @Email(message="Digite um email valido")
        String email,

        @NotBlank(message="A senha deve ser preenchida")
        @Size(min=6 , message ="A senha deve conter no minimo 6 caracteres")
        String senha,

        String tipoUsuario) { }
