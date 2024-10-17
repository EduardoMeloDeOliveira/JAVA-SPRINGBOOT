package med.voll.api.domain.paciente.entity;


import jakarta.persistence.*;
import lombok.*;
import med.voll.api.domain.endereco.entity.Endereco;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;

    private Boolean isActivePaciente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;


}
