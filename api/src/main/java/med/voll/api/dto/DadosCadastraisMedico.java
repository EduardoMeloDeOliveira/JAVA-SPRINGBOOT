package med.voll.api.dto;

import med.voll.api.enums.Especialidade;

public record DadosCadastraisMedico(
        String nome,
        String email,
        Especialidade especialidade,
        DadosResidenciais endereco)
{
}
