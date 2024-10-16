package med.voll.api.medico.DTO;

import lombok.Builder;
import med.voll.api.medico.enums.Especialidade;

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
