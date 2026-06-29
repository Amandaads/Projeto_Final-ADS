package com.multidisciplinar.ProjetoFinal.Service;

import com.multidisciplinar.ProjetoFinal.DTO.RequestPacienteDTO;
import com.multidisciplinar.ProjetoFinal.DTO.ResponsePacienteDTO;
import com.multidisciplinar.ProjetoFinal.DTO.UpdatePacienteDTO;
import com.multidisciplinar.ProjetoFinal.Domain.Paciente;
import com.multidisciplinar.ProjetoFinal.Domain.TipoUsuario;
import com.multidisciplinar.ProjetoFinal.Domain.Usuario;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;

import com.multidisciplinar.ProjetoFinal.Repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;


@Service
public class PacienteService {
    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository){
        this.pacienteRepository = pacienteRepository;
    }

    public ResponsePacienteDTO cadastroPaciente(RequestPacienteDTO data){
        Usuario usuarioLog = new Usuario();
        usuarioLog.setEmail(data.email());
        usuarioLog.setSenha(data.senha());
        usuarioLog.setTipoUsuario(TipoUsuario.PACIENTE);

        Paciente paciente = new Paciente();
        paciente.setNome(data.nome());
        paciente.setCpf(data.cpf());
        paciente.setTelefone(data.telefone());
        paciente.setNascimento(data.nascimento());
        paciente.setEndereco(data.endereco());

        paciente.setUsuario(usuarioLog);
        Paciente pacienteSalvo = pacienteRepository.save(paciente);
        return new ResponsePacienteDTO(
                pacienteSalvo.getId(),
                pacienteSalvo.getNome(),
                pacienteSalvo.getTelefone(),
                pacienteSalvo.getEndereco(),
                pacienteSalvo.getNascimento()
        );


    }

    public ResponsePacienteDTO atualizarPaciente(UUID id, UpdatePacienteDTO data){
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if(paciente.isPresent()){
            Paciente paciente1 = paciente.get();

            if(data.nome() != null) paciente1.setNome(data.nome());
            if(data.telefone() != null) paciente1.setTelefone(data.telefone());
            if(data.nascimento() != null) paciente1.setNascimento(data.nascimento());
            if(data.endereco() != null) paciente1.setEndereco(data.endereco());

            Paciente pacienteatt = pacienteRepository.save(paciente1);

            return new ResponsePacienteDTO(
                    pacienteatt.getId(),
                    pacienteatt.getNome(),
                    pacienteatt.getTelefone(),
                    pacienteatt.getEndereco(),
                    pacienteatt.getNascimento()
            );
        }else {
            throw new EntityNotFoundException("Paciente com id nao encontrado");
        }
    }



    
    


}
