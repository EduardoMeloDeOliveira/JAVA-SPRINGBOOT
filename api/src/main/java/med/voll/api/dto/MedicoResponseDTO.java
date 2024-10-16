package med.voll.api.dto;

import lombok.Builder;
import med.voll.api.enums.Especialidade;

@Builder
public record MedicoResponseDTO(

        Long medicoId,
        String nome,
        String crm,
        String email,
        Especialidade especialidade
        ) {
}
