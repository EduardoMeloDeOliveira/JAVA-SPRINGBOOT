package med.voll.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record MedicoPutRequestDTO(

        @NotBlank
        String novoNome,

        @NotBlank
        @Size(min = 11, max = 11)
        @Digits(integer = 11, fraction = 0)
        String telefone,

        @NotNull
        @Valid
        DadosResidenciais endereco
) {
}
