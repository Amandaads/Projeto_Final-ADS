package com.multidisciplinar.ProjetoFinal.Domain;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Profissional")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfissionalSaude {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private String id;

    @OneToOne
    @JoinColumn(name="id_usuario", nullable=false)
    private Usuario usuario;

    private String nomeCompleto;

    @Column(name="matricula", unique = true, nullable= false)
    private String matricula;

    private String cargo;

    private String telefone;
    

}
