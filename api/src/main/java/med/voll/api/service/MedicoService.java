package med.voll.api.service;

import lombok.AllArgsConstructor;
import med.voll.api.dto.DadosCadastraisMedico;
import med.voll.api.entity.Medico;
import med.voll.api.mapper.MedicoMapper;
import med.voll.api.repository.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public Medico saveMedico(DadosCadastraisMedico dadosMedico){
        Medico medico = MedicoMapper.medicoDTOToMedicoEntity(dadosMedico);
        return medicoRepository.save(medico);
    }

    public List<Medico> findAllMedico(){
        return medicoRepository.findAll();
    }
}
