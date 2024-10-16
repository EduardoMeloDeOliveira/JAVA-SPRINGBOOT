package med.voll.api.mapper;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import med.voll.api.dto.DadosCadastraisMedico;
import med.voll.api.dto.DadosResidenciais;
import med.voll.api.entity.Endereco;
import med.voll.api.entity.Medico;

@Getter
@Setter
@Builder
public class MedicoMapper {


    public static Medico medicoDTOToMedicoEntity(DadosCadastraisMedico dadosMedico){
        return  Medico.builder()
                .id(null)
                .crm(dadosMedico.crm())
                .email(dadosMedico.email())
                .nome(dadosMedico.nome())
                .endereco(enderecoDTOToEnderecoEntity(dadosMedico.endereco()))
                .especialidade(dadosMedico.especialidade())
                .telefone(dadosMedico.telefone())
                .build();
    }

    public static Endereco enderecoDTOToEnderecoEntity(DadosResidenciais dadosResidenciais){

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



}
