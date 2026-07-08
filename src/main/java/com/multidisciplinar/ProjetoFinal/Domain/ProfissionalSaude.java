package com.multidisciplinar.ProjetoFinal.Domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name="Profissional")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfissionalSaude {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="usuario_id",nullable=false, referencedColumnName = "id")
    private Usuario usuario;

    @Column(name = "nome")
    private String nome;

    @Column(name="matricula", unique = true, nullable= false)
    private String matricula;

    @Column(name="cargo")
    private String cargo;

    @Column(name = "telefone")
    private String telefone;
    

}
