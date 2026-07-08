package com.multidisciplinar.ProjetoFinal.Service;


import com.multidisciplinar.ProjetoFinal.DTO.RequestProfissionalDTO;
import com.multidisciplinar.ProjetoFinal.DTO.ResponseProfDTO;
import com.multidisciplinar.ProjetoFinal.Domain.ProfissionalSaude;
import com.multidisciplinar.ProjetoFinal.Domain.TipoUsuario;
import com.multidisciplinar.ProjetoFinal.Domain.Usuario;
import com.multidisciplinar.ProjetoFinal.Repository.ProfissionalSaudeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProfissionalSaudeService {
    private final ProfissionalSaudeRepository profissionalRepository;

    public ProfissionalSaudeService(ProfissionalSaudeRepository profissionalRepository){
        this.profissionalRepository = profissionalRepository;
    }

    public ResponseProfDTO cadastroMedico(RequestProfissionalDTO data){
        Usuario usuarioLog = new Usuario();
        usuarioLog.setEmail(data.email());
        usuarioLog.setSenha(data.senha());
        usuarioLog.setTipoUsuario(TipoUsuario.PROFISSIONAL);


        ProfissionalSaude profissional = new ProfissionalSaude();
        profissional.setNome(data.nome());
        profissional.setMatricula(data.matricula());
        profissional.setCargo(data.cargo());
        profissional.setTelefone(data.telefone());

        profissional.setUsuario(usuarioLog);

        ProfissionalSaude profBanco = profissionalRepository.save(profissional);

        return new ResponseProfDTO(
                profBanco.getId(),
                profBanco.getNome(),
                profBanco.getMatricula(),
                profBanco.getCargo(),
                profBanco.getTelefone()

        );

    }

    public ResponseProfDTO atualizarProfissional (UUID id, RequestProfissionalDTO data){
        Optional<ProfissionalSaude> optionalProf = profissionalRepository.findById(id);
        if(optionalProf.isPresent()){
            ProfissionalSaude prof1 = optionalProf.get();

            if(data.nome() != null) prof1.setNome(data.nome());
            if(data.matricula() != null) prof1.setMatricula(data.matricula());
            if(data.cargo() != null) prof1.setCargo(data.cargo());
            if(data.telefone() != null ) prof1.setTelefone(data.telefone());

            ProfissionalSaude profissionalAtt = profissionalRepository.save(prof1);

            return new ResponseProfDTO(
                    profissionalAtt.getId(),
                    profissionalAtt.getNome(),
                    profissionalAtt.getMatricula(),
                    profissionalAtt.getCargo(),
                    profissionalAtt.getTelefone()
            );
        } else {
            throw new EntityNotFoundException("Profissional com ID, não encontrado!");
        }
    }





}
