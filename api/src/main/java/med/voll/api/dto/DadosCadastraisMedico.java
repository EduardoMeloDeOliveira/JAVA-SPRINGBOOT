package med.voll.api.dto;

import med.voll.api.enums.Especialidade;

public record DadosCadastraisMedico(
        String nome,
        String email,
        String crm,
        Especialidade especialidade,
        DadosResidenciais endereco)
{
}
