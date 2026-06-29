package com.multidisciplinar.ProjetoFinal.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multidisciplinar.ProjetoFinal.Domain.ProfissionalSaude;

public interface ProfissionalSaudeRepository extends JpaRepository<ProfissionalSaude, UUID> {

}
