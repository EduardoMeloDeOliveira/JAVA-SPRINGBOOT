package med.voll.api.entity;


import jakarta.persistence.*;
import lombok.*;
import med.voll.api.dto.DadosResidenciais;
import med.voll.api.enums.Especialidade;

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

    private Boolean isActive = true;
}
