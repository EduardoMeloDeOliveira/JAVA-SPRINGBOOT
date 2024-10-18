package med.voll.api.domain.consulta.DTO;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record ConsultaRequestDTO (
        @NotBlank
        Long medicoId,

        @NotBlank
        Long pacienteId,

        @NotBlank
        @Future
        LocalDateTime dataConsulta){
}
