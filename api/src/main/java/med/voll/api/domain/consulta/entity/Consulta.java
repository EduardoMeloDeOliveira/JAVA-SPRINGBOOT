package med.voll.api.domain.consulta.entity;


import jakarta.persistence.*;
import lombok.*;
import med.voll.api.domain.medico.entity.Medico;
import med.voll.api.domain.paciente.entity.Paciente;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id" , nullable = false)
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id",nullable = false)
    private Paciente paciente;

    private LocalDateTime dataConsulta;


}
