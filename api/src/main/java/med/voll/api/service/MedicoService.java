package med.voll.api.service;

import lombok.AllArgsConstructor;
import med.voll.api.dto.DadosCadastraisMedico;
import med.voll.api.dto.MedicoPutRequestDTO;
import med.voll.api.dto.MedicoResponseDTO;
import med.voll.api.entity.Endereco;
import med.voll.api.entity.Medico;
import med.voll.api.mapper.EnderecoMapper;
import med.voll.api.mapper.MedicoMapper;
import med.voll.api.repository.MedicoRepository;
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
        medicoRepository.save(medico);
       return MedicoMapper.MedicoEntityToMedicoDTO(medico);

    }

    public List<MedicoResponseDTO> findAllMedico() {
        List<Medico> medicos = medicoRepository.findAll();
        List<MedicoResponseDTO> medicoResponseDTOS = new ArrayList<>();

        if (!medicos.isEmpty()) {
            medicoResponseDTOS = medicos.stream()
                    .map(m -> new MedicoResponseDTO(m.getId(),m.getNome(), m.getCrm(),m.getEmail(), m.getEspecialidade()))
                    .collect(Collectors.toList());

        }

        return medicoResponseDTOS;
    }

    public MedicoResponseDTO updateSomeDatasFromMedico(Long medicoId,MedicoPutRequestDTO medicoNovosDados){

        Optional<Medico> medicoOpt = medicoRepository.findById(medicoId);

        if(medicoOpt.isPresent()){
            Medico medico = medicoOpt.get();
            Endereco endereco = medico.getEndereco();
            Endereco novoEndereco = EnderecoMapper.enderecoSetter(endereco,medicoNovosDados.endereco());

            medico.setNome(medicoNovosDados.novoNome());
            medico.setTelefone(medicoNovosDados.telefone());
            medico.setEndereco(novoEndereco);
            medicoRepository.save(medico);
            return MedicoMapper.MedicoEntityToMedicoDTO(medico);
        }

        return null;
    }


    public void deleteMedico(Long medicoId) {
        Optional<Medico> medicoOpt = medicoRepository.findById(medicoId);

        if(medicoOpt.isPresent()){
            Medico medico = medicoOpt.get();
            medicoRepository.delete(medico);
        }

    }
}
