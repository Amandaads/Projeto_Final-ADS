package com.multidisciplinar.ProjetoFinal.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Admin")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Admin {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private String id;

    @OneToOne
    @JoinColumn(name="id_usuario", nullable=false)
    private Usuario usuario;

    private String nomeCompleto;


}
