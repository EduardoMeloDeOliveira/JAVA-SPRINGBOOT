package med.voll.api.domain.consulta.DTO;

import lombok.Builder;
import med.voll.api.domain.paciente.DTO.PacienteResponseDTO;

import java.time.LocalDateTime;

@Builder
public record ConsultaReponseDTO(LocalDateTime dataConsulta, PacienteResponseDTO pacienteResponseDTO) {
}
