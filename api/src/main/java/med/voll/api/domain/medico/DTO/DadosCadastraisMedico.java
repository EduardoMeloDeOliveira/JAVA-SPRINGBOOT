package med.voll.api.domain.medico.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Builder;
import med.voll.api.domain.endereco.DTO.DadosResidenciais;
import med.voll.api.domain.medico.enums.Especialidade;
@Builder
public record DadosCadastraisMedico(
        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Size(min = 11, max = 11)
        @Digits(integer = 11, fraction = 0)
        String telefone,

        @NotBlank
        @Size(min = 4, max = 6)
        @Digits(integer = 6, fraction = 0)
        String crm,

        @NotNull
        Especialidade especialidade,

        @NotNull
        @Valid
        DadosResidenciais endereco) {
}
