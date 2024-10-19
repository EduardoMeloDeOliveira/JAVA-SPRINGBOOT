package med.voll.api.domain.medico.DTO;

import lombok.Builder;
import med.voll.api.domain.consulta.DTO.ConsultaReponseDTO;

import java.util.List;

@Builder
public record MedicoDetailsConsultasDTO(String medicoNome, List<ConsultaReponseDTO> consultaReponseDTOList) {
}
