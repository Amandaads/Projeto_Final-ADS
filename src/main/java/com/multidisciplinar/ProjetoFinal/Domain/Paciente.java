package com.multidisciplinar.ProjetoFinal.Domain;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="Paciente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    @JoinColumn(name="id_usuario", nullable=false)
    private Usuario usuario;

    
    private String nomeCompleto;
    private String cpf;
    private Date dataNascimento;
    private String telefone;
    private String endereço;
    

    
}
