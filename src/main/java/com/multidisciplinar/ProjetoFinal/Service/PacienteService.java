package com.multidisciplinar.ProjetoFinal.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.multidisciplinar.ProjetoFinal.Repository.PacienteRepository;

public class PacienteService {
    @Autowired
    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository){
        this.pacienteRepository = pacienteRepository;
    }

    
    


}
