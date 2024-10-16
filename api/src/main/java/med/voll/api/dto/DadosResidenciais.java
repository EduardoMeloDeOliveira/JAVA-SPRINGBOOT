package med.voll.api.dto;

public record DadosResidenciais(String logradoura,
                                String bairro,
                                String cep,
                                String cidade,
                                String uf,
                                String complemento,
                                String numero) {
}
