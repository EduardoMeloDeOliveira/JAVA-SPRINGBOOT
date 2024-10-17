package med.voll.api.domain.endereco.DTO;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record DadosResidenciais(

        @NotBlank
        String logradoura,

        @NotBlank
        String bairro,

        @NotBlank
        @Size(min = 8,max = 8)
        @Digits(integer = 8, fraction = 0)
        String cep,

        @NotBlank
        String cidade,

        @NotBlank
        String uf,

        String complemento,

        String numero) {
}
