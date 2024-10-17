package med.voll.api.domain.paciente.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import med.voll.api.domain.endereco.DTO.DadosResidenciais;

public record PacientePutRequestDTO(
        @NotBlank
        String nome,

        @NotBlank
        @Size(min = 11,max = 11)
        @Digits(integer = 11,fraction = 0)
        String telefone,

        @NotNull
        @Valid
        DadosResidenciais endereco
) {
}
