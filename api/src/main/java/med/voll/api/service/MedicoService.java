package med.voll.api.service;

import lombok.AllArgsConstructor;
import med.voll.api.dto.DadosCadastraisMedico;
import med.voll.api.dto.MedicoResponseDTO;
import med.voll.api.entity.Medico;
import med.voll.api.mapper.MedicoMapper;
import med.voll.api.repository.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public MedicoResponseDTO saveMedico(DadosCadastraisMedico dadosMedico) {
        Medico medico = MedicoMapper.medicoDTOToMedicoEntity(dadosMedico);
       return MedicoMapper.MedicoEntityToMedicoDTO(medico);

    }

    public List<MedicoResponseDTO> findAllMedico() {
        List<Medico> medicos = medicoRepository.findAll();
        List<MedicoResponseDTO> medicoResponseDTOS = new ArrayList<>();

        if (!medicos.isEmpty()) {
            medicoResponseDTOS = medicos.stream()
                    .map(m -> new MedicoResponseDTO(m.getNome(), m.getCrm(), m.getEspecialidade()))
                    .collect(Collectors.toList());

        }

        return medicoResponseDTOS;
    }
}
