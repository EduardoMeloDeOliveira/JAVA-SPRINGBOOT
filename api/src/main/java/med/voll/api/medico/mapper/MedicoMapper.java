package med.voll.api.medico.mapper;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import med.voll.api.endereco.mapper.EnderecoMapper;
import med.voll.api.medico.DTO.DadosCadastraisMedico;
import med.voll.api.medico.DTO.MedicoResponseDTO;
import med.voll.api.medico.entity.Medico;

@Getter
@Setter
@Builder
public class MedicoMapper {


    public static Medico medicoDTOToMedicoEntity(DadosCadastraisMedico dadosMedico) {
        return Medico.builder()
                .id(null)
                .crm(dadosMedico.crm())
                .email(dadosMedico.email())
                .nome(dadosMedico.nome())
                .endereco(EnderecoMapper.dadosResidenciasToEnderecoEntity(dadosMedico.endereco()))
                .especialidade(dadosMedico.especialidade())
                .telefone(dadosMedico.telefone())
                .isActive(true)
                .build();
    }



    public static MedicoResponseDTO MedicoEntityToMedicoDTO(Medico medico) {

        return MedicoResponseDTO.builder()
                .medicoId(medico.getId())
                .nome(medico.getNome())
                .crm(medico.getCrm())
                .email(medico.getEmail())
                .especialidade(medico.getEspecialidade())
                .medicoEstaAtivo(medico.getIsActive())
                .build();

    }

}
