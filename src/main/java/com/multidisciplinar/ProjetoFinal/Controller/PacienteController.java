package com.multidisciplinar.ProjetoFinal.Controller;

import com.multidisciplinar.ProjetoFinal.DTO.RequestPacienteDTO;
import com.multidisciplinar.ProjetoFinal.DTO.ResponsePacienteDTO;
import com.multidisciplinar.ProjetoFinal.DTO.UpdatePacienteDTO;
import com.multidisciplinar.ProjetoFinal.Service.PacienteService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private final PacienteService pacienteService;
    public PacienteController(PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }


    @PostMapping
    public ResponseEntity<?> createPaciente(@RequestBody @Valid RequestPacienteDTO data){
        try{
            ResponsePacienteDTO novoPaciente = pacienteService.cadastroPaciente(data);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoPaciente);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao cadastrar");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePaciente (@PathVariable UUID id, @RequestBody UpdatePacienteDTO data){
        try{
            ResponsePacienteDTO pacienteatt = pacienteService.atualizarPaciente(id, data);
            return ResponseEntity.ok(pacienteatt);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
