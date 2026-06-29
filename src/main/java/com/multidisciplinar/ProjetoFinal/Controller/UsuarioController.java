package com.multidisciplinar.ProjetoFinal.Controller;

import com.multidisciplinar.ProjetoFinal.DTO.RequestUserDTO;
import com.multidisciplinar.ProjetoFinal.DTO.ResponseUserDTO;
import com.multidisciplinar.ProjetoFinal.Domain.Usuario;
import com.multidisciplinar.ProjetoFinal.Service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.UUID;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity getAllUsers(){
        var allUsers = usuarioService.getAll();
        return ResponseEntity.ok(allUsers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable UUID id){
        try{
            ResponseUserDTO usuario = usuarioService.getById(id);
            return ResponseEntity.ok(usuario);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    
    @PostMapping
    public ResponseEntity<ResponseUserDTO>createUser(@RequestBody @Valid RequestUserDTO data){
        ResponseUserDTO responseUserDTO = usuarioService.registrarUser(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseUserDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable UUID id, @RequestBody RequestUserDTO data){
        try{
            ResponseUserDTO update = usuarioService.atualizaUser(id, data);
            return ResponseEntity.ok(update);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable UUID id){
        try {
            usuarioService.deletaUser(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }




}
