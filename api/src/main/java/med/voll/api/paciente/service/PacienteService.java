package med.voll.api.paciente.service;

import lombok.RequiredArgsConstructor;
import med.voll.api.paciente.DTO.DadosCadastraisPacientes;
import med.voll.api.paciente.DTO.PacienteResponseDTO;
import med.voll.api.paciente.entity.Paciente;
import med.voll.api.paciente.mapper.PacienteMapper;
import med.voll.api.paciente.repository.PacienteRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PacienteService {


    private final PacienteRepository pacienteRepository;


    public PacienteResponseDTO savePaciente(DadosCadastraisPacientes dadosCadastraisPacientes) {

        Paciente paciente = PacienteMapper.pacienteDTOToPacienteEntity(dadosCadastraisPacientes);

        pacienteRepository.save(paciente);

        return PacienteMapper.pacienteEntityToPacienteResponseDTO(paciente);

    }

}
