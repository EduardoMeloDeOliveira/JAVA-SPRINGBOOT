package med.voll.api.dto;

import lombok.Builder;
import med.voll.api.enums.Especialidade;

@Builder
public record MedicoResponseDTO(

        String nome,
        String crm,
        Especialidade especialidade
        ) {
}
