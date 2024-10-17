package med.voll.api.domain.endereco.mapper;

import med.voll.api.domain.endereco.DTO.DadosResidenciais;
import med.voll.api.domain.endereco.DTO.EnderecoResponseDTO;
import med.voll.api.domain.endereco.entity.Endereco;

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

    public static Endereco dadosResidenciasToEnderecoEntity(DadosResidenciais dadosResidenciais) {

        return Endereco.builder()
                .id(null)
                .cep(dadosResidenciais.cep())
                .uf(dadosResidenciais.uf())
                .complemento(dadosResidenciais.complemento())
                .numero(dadosResidenciais.numero())
                .logradoura(dadosResidenciais.logradoura())
                .bairro(dadosResidenciais.bairro())
                .cidade(dadosResidenciais.cidade())
                .build();
    }

    public static EnderecoResponseDTO enderecoEntityToEnderecoResponseDTO(Endereco endereco) {

        return EnderecoResponseDTO.builder()
                .cep(endereco.getCep())
                .uf(endereco.getUf())
                .bairro(endereco.getBairro())
                .cidade(endereco.getCidade())
                .logradoura(endereco.getLogradoura())
                .build();


    }


}
