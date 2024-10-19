package med.voll.api.domain.consulta.DTO;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ConsultaRequestDTO (
        @NotNull
        Long medicoId,

        @NotNull
        Long pacienteId,

        @NotNull
        @Future
        LocalDateTime dataConsulta){
}
