package med.voll.api.domain.paciente.service;

import lombok.RequiredArgsConstructor;
import med.voll.api.domain.endereco.entity.Endereco;
import med.voll.api.domain.endereco.mapper.EnderecoMapper;
import med.voll.api.domain.infra.exception.DuplicateKeyViolation;
import med.voll.api.domain.infra.exception.ObjectNotFoundException;
import med.voll.api.domain.paciente.DTO.DadosCadastraisPacientes;
import med.voll.api.domain.paciente.DTO.PacientePutRequestDTO;
import med.voll.api.domain.paciente.DTO.PacienteResponseDTO;
import med.voll.api.domain.paciente.entity.Paciente;
import med.voll.api.domain.paciente.mapper.PacienteMapper;
import med.voll.api.domain.paciente.repository.PacienteRepository;
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

        if (pacienteRepository.existsPacienteByEmail(paciente.getEmail())) {
            throw new DuplicateKeyViolation("Email ja cadastrado");
        }


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

        throw new ObjectNotFoundException("Paciente com id %d não econtrado".formatted(id));


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

    public PacienteResponseDTO deletePaciente(Long id) {
        Optional<Paciente> pacienteOpt = pacienteRepository.findById(id);

        if (pacienteOpt.isPresent()) {
            Paciente paciente = pacienteOpt.get();
            paciente.setIsActivePaciente(false);
            pacienteRepository.save(paciente);
            return PacienteMapper.pacienteEntityToPacienteResponseDTO(paciente);
        }


        throw new ObjectNotFoundException("Paciente com id %d não econtrado".formatted(id));

    }

}
