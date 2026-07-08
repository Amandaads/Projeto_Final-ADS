package com.multidisciplinar.ProjetoFinal.Controller;


import com.multidisciplinar.ProjetoFinal.DTO.RequestProfissionalDTO;
import com.multidisciplinar.ProjetoFinal.DTO.ResponseProfDTO;
import com.multidisciplinar.ProjetoFinal.Service.ProfissionalSaudeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/medicos")
public class ProfissionalController {

    private final ProfissionalSaudeService profService;

    public ProfissionalController(ProfissionalSaudeService profService){
        this.profService = profService;
    }

    @PostMapping
    public ResponseEntity<?> createProfissional(@RequestBody @Valid RequestProfissionalDTO data) {
        try {
            ResponseProfDTO novoProfissional = profService.cadastroMedico(data);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoProfissional);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro no cadastro de profissional!");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProfissional(@PathVariable UUID id, @RequestBody RequestProfissionalDTO data){
        try{
            ResponseProfDTO profAtt = profService.atualizarProfissional(id, data);
            return ResponseEntity.ok(profAtt);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        }
    }
