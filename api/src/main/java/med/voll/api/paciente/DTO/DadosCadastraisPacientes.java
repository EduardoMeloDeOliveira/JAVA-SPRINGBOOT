package med.voll.api.paciente.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Builder;
import med.voll.api.endereco.DTO.DadosResidenciais;

@Builder
public record DadosCadastraisPacientes(
        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Size(min = 11,max = 11)
        @Digits(integer = 11,fraction = 0)
        String telefone,

        @NotNull
        @Valid
        DadosResidenciais dadosResidenciais

) {
}
