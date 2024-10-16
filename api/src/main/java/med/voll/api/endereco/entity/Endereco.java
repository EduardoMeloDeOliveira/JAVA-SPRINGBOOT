package med.voll.api.endereco.entity;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.paciente.entity.Paciente;
import med.voll.api.medico.entity.Medico;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logradoura;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;
    private String numero;

    @OneToOne(mappedBy = "endereco")
    private Medico medico;

    @OneToOne(mappedBy = "endereco")
    private Paciente paciente;
}
