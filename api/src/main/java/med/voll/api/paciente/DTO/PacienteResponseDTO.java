package med.voll.api.paciente.DTO;

import lombok.Builder;
import med.voll.api.endereco.DTO.EnderecoResponseDTO;

@Builder
public record PacienteResponseDTO(
        Long idPaciente,
        String nome,
        String telefone,
        EnderecoResponseDTO endereco

) {
}
