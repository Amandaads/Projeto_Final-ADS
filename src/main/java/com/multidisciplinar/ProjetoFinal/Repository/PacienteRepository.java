package com.multidisciplinar.ProjetoFinal.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multidisciplinar.ProjetoFinal.Domain.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, UUID>{

}
