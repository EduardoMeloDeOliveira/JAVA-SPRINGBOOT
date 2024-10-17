package med.voll.api.paciente.service;

import lombok.RequiredArgsConstructor;
import med.voll.api.endereco.entity.Endereco;
import med.voll.api.endereco.mapper.EnderecoMapper;
import med.voll.api.paciente.DTO.DadosCadastraisPacientes;
import med.voll.api.paciente.DTO.PacientePutRequestDTO;
import med.voll.api.paciente.DTO.PacienteResponseDTO;
import med.voll.api.paciente.entity.Paciente;
import med.voll.api.paciente.mapper.PacienteMapper;
import med.voll.api.paciente.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PacienteService {


    private final PacienteRepository pacienteRepository;


    public PacienteResponseDTO savePaciente(DadosCadastraisPacientes dadosCadastraisPacientes) {

        Paciente paciente = PacienteMapper.pacienteDTOToPacienteEntity(dadosCadastraisPacientes);

        pacienteRepository.save(paciente);

        return PacienteMapper.pacienteEntityToPacienteResponseDTO(paciente);

    }

    public PacienteResponseDTO updatePaciente(Long id, PacientePutRequestDTO pacienteData) {
        Optional<Paciente> pacienteOpt = pacienteRepository.findById(id);

        if (pacienteOpt.isPresent()) {
            Paciente paciente = pacienteOpt.get();
            Endereco endereco = paciente.getEndereco();
            Endereco novoEndereco = EnderecoMapper.enderecoSetter(endereco, pacienteData.endereco());
            paciente.setEndereco(novoEndereco);
            paciente.setNome(pacienteData.nome());
            paciente.setTelefone(pacienteData.telefone());

            pacienteRepository.save(paciente);

            return PacienteMapper.pacienteEntityToPacienteResponseDTO(paciente);
        }

        return null;


    }

    public List<PacienteResponseDTO> getAllPacientes() {

        List<Paciente> pacientes = pacienteRepository.findAll();

        if (!pacientes.isEmpty()) {
            List<PacienteResponseDTO> pacienteResponseDTOS = pacientes
                    .stream()
                    .map(paciente -> PacienteMapper.pacienteEntityToPacienteResponseDTO(paciente))
                    .collect(Collectors.toList());
            return pacienteResponseDTOS;
        }

        return null;
    }

    public List<PacienteResponseDTO> getActivePacientes() {
        List<Paciente> pacientes = pacienteRepository.findPacienteByIsActivePacienteTrue();

        if (!pacientes.isEmpty()) {
            List<PacienteResponseDTO> pacienteResponseDTOS = pacientes.stream()
                    .map(paciente -> PacienteMapper.pacienteEntityToPacienteResponseDTO(paciente))
                    .collect(Collectors.toList());

            return pacienteResponseDTOS;
        }

        return null;


    }

    public List<PacienteResponseDTO> getDesabledPacientes() {
        List<Paciente> pacientes = pacienteRepository.findPacienteByIsActivePacienteFalse();

        if (!pacientes.isEmpty()) {
            List<PacienteResponseDTO> pacienteResponseDTOS = pacientes.stream()
                    .map(paciente -> PacienteMapper.pacienteEntityToPacienteResponseDTO(paciente))
                    .collect(Collectors.toList());

            return pacienteResponseDTOS;
        }

        return null;

    }

    public void deletePaciente(Long id) {
        Optional<Paciente> pacienteOpt = pacienteRepository.findById(id);

        if (pacienteOpt.isPresent()) {
            Paciente paciente = pacienteOpt.get();
            paciente.setIsActivePaciente(false);
            pacienteRepository.save(paciente);
        }
    }

}
