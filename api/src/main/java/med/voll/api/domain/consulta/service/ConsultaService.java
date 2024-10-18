package med.voll.api.domain.consulta.service;

import lombok.RequiredArgsConstructor;
import med.voll.api.domain.consulta.DTO.ConsultaReponseDTO;
import med.voll.api.domain.consulta.DTO.ConsultaRequestDTO;
import med.voll.api.domain.consulta.entity.Consulta;
import med.voll.api.domain.consulta.mapper.ConsultaMapper;
import med.voll.api.domain.consulta.repository.ConsultaRepository;
import med.voll.api.domain.infra.exception.ObjectNotFoundException;
import med.voll.api.domain.medico.entity.Medico;
import med.voll.api.domain.medico.repository.MedicoRepository;
import med.voll.api.domain.paciente.entity.Paciente;
import med.voll.api.domain.paciente.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final MedicoRepository medicoRepository;
    private final PacienteRepository pacienteRepository;


    public ConsultaReponseDTO createConsulta(ConsultaRequestDTO consultaRequestDTO) {

        Optional<Medico> medicoOpt = medicoRepository.findById(consultaRequestDTO.medicoId());

        Optional<Paciente> pacienteOpt = pacienteRepository.findById(consultaRequestDTO.pacienteId());

        if(medicoOpt.isEmpty()){
            throw new ObjectNotFoundException("Medico não encontrado");
        }

        if(pacienteOpt.isEmpty()){
            throw new ObjectNotFoundException("Paciente não encontrado");
        }

        Medico medico = medicoOpt.get();
        Paciente paciente = pacienteOpt.get();

        Consulta consulta = Consulta.builder()
                .id(null)
                .medico(medico)
                .paciente(paciente)
                .dataConsulta(consultaRequestDTO.dataConsulta())
                .build();

        consultaRepository.save(consulta);

        return ConsultaMapper.entityToDTO(consulta);

    }



}
