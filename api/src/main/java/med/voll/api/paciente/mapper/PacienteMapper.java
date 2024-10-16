package med.voll.api.paciente.mapper;

import med.voll.api.endereco.mapper.EnderecoMapper;
import med.voll.api.paciente.DTO.DadosCadastraisPacientes;
import med.voll.api.paciente.DTO.PacienteResponseDTO;
import med.voll.api.paciente.entity.Paciente;

public class PacienteMapper {

   public static Paciente pacienteDTOToPacienteEntity(DadosCadastraisPacientes pacienteDTO) {

       return Paciente.builder()
               .id(null)
               .nome(pacienteDTO.nome())
               .email(pacienteDTO.email())
               .telefone(pacienteDTO.telefone())
               .isActivePaciente(true)
               .endereco(EnderecoMapper.dadosResidenciasToEnderecoEntity(pacienteDTO.dadosResidenciais()))
               .build();

   }


   public static PacienteResponseDTO pacienteEntityToPacienteResponseDTO(Paciente paciente) {
       return PacienteResponseDTO.builder()
               .idPaciente(paciente.getId())
               .nome(paciente.getNome())
               .telefone(paciente.getTelefone())
               .endereco(EnderecoMapper.enderecoEntityToEnderecoResponseDTO(paciente.getEndereco()))
               .build();

   }
}
