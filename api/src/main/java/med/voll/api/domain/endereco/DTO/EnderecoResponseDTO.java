package med.voll.api.domain.endereco.DTO;

import lombok.Builder;

@Builder
public record EnderecoResponseDTO(
        String logradoura,
        String bairro,
        String cep,
        String cidade,
        String uf
) {
}
