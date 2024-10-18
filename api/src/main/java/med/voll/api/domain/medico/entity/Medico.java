package med.voll.api.domain.medico.entity;


import jakarta.persistence.*;
import lombok.*;
import med.voll.api.domain.consulta.entity.Consulta;
import med.voll.api.domain.endereco.entity.Endereco;
import med.voll.api.domain.medico.enums.Especialidade;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String crm;
    private String telefone;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @Column(name = "isactive")
    private Boolean isActive;

    @OneToMany(mappedBy = "medico")
    private List<Consulta> consultas;
}
