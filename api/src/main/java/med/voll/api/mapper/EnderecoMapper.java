package med.voll.api.mapper;

import med.voll.api.dto.DadosResidenciais;
import med.voll.api.entity.Endereco;

public class EnderecoMapper {


    public static Endereco enderecoSetter(Endereco endereco, DadosResidenciais dadosResidenciais) {
        endereco.setLogradoura(dadosResidenciais.logradoura());
        endereco.setBairro(dadosResidenciais.bairro());
        endereco.setCep(dadosResidenciais.cep());
        endereco.setCidade(dadosResidenciais.cidade());
        endereco.setUf(dadosResidenciais.uf());
        endereco.setComplemento(dadosResidenciais.complemento());
        endereco.setNumero(dadosResidenciais.numero());

        return endereco;

    }
}
