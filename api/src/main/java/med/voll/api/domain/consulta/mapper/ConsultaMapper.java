package med.voll.api.domain.consulta.mapper;

import med.voll.api.domain.consulta.DTO.ConsultaReponseDTO;
import med.voll.api.domain.consulta.entity.Consulta;
import med.voll.api.domain.paciente.mapper.PacienteMapper;

public class ConsultaMapper {

    public static ConsultaReponseDTO entityToDTO(Consulta consulta) {

        return ConsultaReponseDTO.builder()
                .pacienteResponseDTO(PacienteMapper.pacienteEntityToPacienteResponseDTO(consulta.getPaciente()))
                .dataConsulta(consulta.getDataConsulta())
                .build();

    }
}
