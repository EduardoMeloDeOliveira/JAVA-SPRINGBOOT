package med.voll.api.domain.medico.mapper;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import med.voll.api.domain.consulta.DTO.ConsultaReponseDTO;
import med.voll.api.domain.consulta.DTO.ConsultaRequestDTO;
import med.voll.api.domain.consulta.entity.Consulta;
import med.voll.api.domain.endereco.mapper.EnderecoMapper;
import med.voll.api.domain.medico.DTO.DadosCadastraisMedico;
import med.voll.api.domain.medico.DTO.MedicoDetailsConsultasDTO;
import med.voll.api.domain.medico.DTO.MedicoResponseDTO;
import med.voll.api.domain.medico.entity.Medico;
import med.voll.api.domain.paciente.mapper.PacienteMapper;

import java.util.List;
import java.util.stream.Collectors;

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
