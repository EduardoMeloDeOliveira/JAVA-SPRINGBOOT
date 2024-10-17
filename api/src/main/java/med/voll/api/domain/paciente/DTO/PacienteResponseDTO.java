package med.voll.api.domain.paciente.DTO;

import lombok.Builder;
import med.voll.api.domain.endereco.DTO.EnderecoResponseDTO;

@Builder
public record PacienteResponseDTO(
        Long idPaciente,
        String nome,
        String telefone,
        Boolean isActivedPaciente,
        EnderecoResponseDTO endereco

) {
}
