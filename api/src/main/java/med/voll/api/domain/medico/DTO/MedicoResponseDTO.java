package med.voll.api.domain.medico.DTO;

import lombok.Builder;
import med.voll.api.domain.medico.enums.Especialidade;

@Builder
public record MedicoResponseDTO(

        Long medicoId,
        String nome,
        String crm,
        String email,
        Boolean medicoEstaAtivo,
        Especialidade especialidade
        ) {
}
