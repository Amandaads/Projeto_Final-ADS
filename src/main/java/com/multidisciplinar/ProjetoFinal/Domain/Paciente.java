package com.multidisciplinar.ProjetoFinal.Domain;

import java.time.LocalDate;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="usuario_id", nullable=false, referencedColumnName = "id")
    private Usuario usuario;

    @Column(name="nome")
    private String nome;

    @Column(name="cpf", unique = true)
    private String cpf;

    @Column(name="nascimento")
    private String nascimento;

    @Column(name="telefone")
    private String telefone;

    @Column(name="endereco")
    private String endereco;
    
}
