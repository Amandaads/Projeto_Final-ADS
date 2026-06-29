package com.multidisciplinar.ProjetoFinal.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multidisciplinar.ProjetoFinal.Domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    boolean existsByEmail(String email);

}
