package com.multidisciplinar.ProjetoFinal.Service;
import com.multidisciplinar.ProjetoFinal.DTO.RequestUserDTO;
import com.multidisciplinar.ProjetoFinal.DTO.ResponseUserDTO;
import com.multidisciplinar.ProjetoFinal.Domain.TipoUsuario;
import jakarta.persistence.EntityNotFoundException;
import org.jspecify.annotations.Nullable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.multidisciplinar.ProjetoFinal.Domain.Usuario;
import com.multidisciplinar.ProjetoFinal.Exception.RegrasDoNegocioException;
import com.multidisciplinar.ProjetoFinal.Repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class UsuarioService {

    private final  UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getAll(){
        return usuarioRepository.findAll();
    }

    public ResponseUserDTO getById(UUID id){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuario com o id não encontrado"));

        return new ResponseUserDTO(
                usuario.getId(),
                usuario.getEmail(),
                usuario.getTipoUsuario()
        );
    }
    public ResponseUserDTO registrarUser( RequestUserDTO data){
        boolean emailTrue = usuarioRepository.existsByEmail(data.email());
        if(emailTrue){
            throw new RegrasDoNegocioException("Este email já esta cadastrado, por favor digite outro!");
        }

        Usuario newUsuario = new Usuario();
        newUsuario.setEmail(data.email());
        newUsuario.setSenha(data.senha());
        newUsuario.setTipoUsuario(TipoUsuario.valueOf(data.tipoUsuario()));

        Usuario userok = usuarioRepository.save(newUsuario);

        return new ResponseUserDTO(
                userok.getId(),
                userok.getEmail(),
                userok.getTipoUsuario()
        );

    }

    public ResponseUserDTO atualizaUser(UUID id, RequestUserDTO data){
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if(optionalUsuario.isPresent()){
            Usuario userExistente = optionalUsuario.get();
            userExistente.setEmail(data.email());
            userExistente.setTipoUsuario(TipoUsuario.valueOf(data.tipoUsuario()));
            Usuario userAtt = usuarioRepository.save(userExistente);

            return new ResponseUserDTO(
                    userAtt.getId(),
                    userAtt.getEmail(),
                    userAtt.getTipoUsuario()
            );
        }else {
            throw new EntityNotFoundException();
        }

    }


    public void deletaUser(UUID id){
        if(!usuarioRepository.existsById(id)){
            throw new EntityNotFoundException("Usuario com id não encontrado!");
        }

        usuarioRepository.deleteById(id);
    }
}
