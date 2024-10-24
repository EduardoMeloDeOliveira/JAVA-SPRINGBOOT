package med.voll.api.domain.medico.service;

import lombok.AllArgsConstructor;
import med.voll.api.domain.consulta.entity.Consulta;
import med.voll.api.domain.consulta.mapper.ConsultaMapper;
import med.voll.api.domain.endereco.entity.Endereco;
import med.voll.api.domain.endereco.mapper.EnderecoMapper;
import med.voll.api.domain.infra.exception.DuplicateKeyViolation;
import med.voll.api.domain.infra.exception.ObjectNotFoundException;
import med.voll.api.domain.medico.DTO.DadosCadastraisMedico;
import med.voll.api.domain.medico.DTO.MedicoDetailsConsultasDTO;
import med.voll.api.domain.medico.DTO.MedicoPutRequestDTO;
import med.voll.api.domain.medico.DTO.MedicoResponseDTO;
import med.voll.api.domain.medico.entity.Medico;
import med.voll.api.domain.medico.mapper.MedicoMapper;
import med.voll.api.domain.medico.repository.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public MedicoResponseDTO saveMedico(DadosCadastraisMedico dadosMedico) {
        Medico medico = MedicoMapper.medicoDTOToMedicoEntity(dadosMedico);

        if (medicoRepository.existsMedicoByCrm(medico.getCrm())) {
            throw new DuplicateKeyViolation("Crm ja cadastrado");
        }

        if (medicoRepository.existsMedicoByEmail(medico.getEmail())) {
            throw new DuplicateKeyViolation("Email ja cadastrado");
        }

        medicoRepository.save(medico);
        return MedicoMapper.MedicoEntityToMedicoDTO(medico);

    }

    public List<MedicoResponseDTO> findAllMedico() {
        List<Medico> medicos = medicoRepository.findAll();
        List<MedicoResponseDTO> medicoResponseDTOS = new ArrayList<>();

        if (!medicos.isEmpty()) {
            medicoResponseDTOS = medicos.stream()
                    .map(m -> MedicoMapper.MedicoEntityToMedicoDTO(m))
                    .collect(Collectors.toList());
            return medicoResponseDTOS;
        }

        return medicoResponseDTOS;

    }

    public MedicoResponseDTO updateSomeDatasFromMedico(Long medicoId, MedicoPutRequestDTO medicoNovosDados) {

        Optional<Medico> medicoOpt = medicoRepository.findById(medicoId);

        if (medicoOpt.isPresent()) {
            Medico medico = medicoOpt.get();
            Endereco endereco = medico.getEndereco();
            Endereco novoEndereco = EnderecoMapper.enderecoSetter(endereco, medicoNovosDados.endereco());

            medico.setNome(medicoNovosDados.novoNome());
            medico.setTelefone(medicoNovosDados.telefone());
            medico.setEndereco(novoEndereco);
            medicoRepository.save(medico);
            return MedicoMapper.MedicoEntityToMedicoDTO(medico);
        }

        throw new ObjectNotFoundException("médico com o id: %d não encontrado".formatted(medicoId));
    }


    public MedicoResponseDTO deleteMedico(Long medicoId) {
        Optional<Medico> medicoOpt = medicoRepository.findById(medicoId);

        if (medicoOpt.isPresent()) {
            Medico medico = medicoOpt.get();
            medico.setIsActive(false);
            medicoRepository.save(medico);
            return MedicoMapper.MedicoEntityToMedicoDTO(medico);

        }

        throw new ObjectNotFoundException("médico com o id: %d não encontrado".formatted(medicoId));

    }

    public List<MedicoResponseDTO> findOnlyActivedMedicos() {
        List<Medico> medicos = medicoRepository.findMedicoByIsActiveTrue();
        List<MedicoResponseDTO> medicosDto = new ArrayList<>();

        if (!medicos.isEmpty()) {
            medicosDto = medicos.stream()
                    .map(m -> MedicoMapper.MedicoEntityToMedicoDTO(m))
                    .collect(Collectors.toList());

            return medicosDto;
        }

        return medicosDto;
    }

    public List<MedicoResponseDTO> findOnlyDesactivedMedicos() {

        List<Medico> medicos = medicoRepository.findMedicoByIsActiveFalse();
        List<MedicoResponseDTO> medicosDto = new ArrayList<>();

        if (!medicos.isEmpty()) {

            medicosDto = medicos.stream()
                    .map(m -> MedicoMapper.MedicoEntityToMedicoDTO(m))
                    .collect(Collectors.toList());

            return medicosDto;
        }

        return medicosDto;
    }

    public MedicoDetailsConsultasDTO getMedicoDetailsById(Long id) {
        Optional<Medico> medicoOpt = medicoRepository.findById(id);

        if (!medicoOpt.isPresent()) {
            throw new ObjectNotFoundException("Médico não encontrado");
        }

        Medico medico = medicoOpt.get();
        List<Consulta> consultas = medico.getConsultas();

        if (consultas.isEmpty()) {
            return MedicoDetailsConsultasDTO.builder()
                    .medicoNome(medico.getNome())
                    .consultaReponseDTOList(null)
                    .build();
        }

        return MedicoDetailsConsultasDTO.builder()
                .medicoNome(medico.getNome())
                .consultaReponseDTOList(consultas.stream()
                        .map(consulta -> ConsultaMapper.entityToDTO(consulta))
                        .collect(Collectors.toList()))
                .build();

    }
}
