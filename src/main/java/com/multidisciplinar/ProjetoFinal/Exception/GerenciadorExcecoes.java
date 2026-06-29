package com.multidisciplinar.ProjetoFinal.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GerenciadorExcecoes {
    @ExceptionHandler(RegrasDoNegocioException.class)
    public ResponseEntity<String> getRegraNegocio(RegrasDoNegocioException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

}
