package med.voll.api.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import med.voll.api.medico.DTO.DadosCadastraisMedico;
import med.voll.api.medico.DTO.MedicoPutRequestDTO;
import med.voll.api.medico.DTO.MedicoResponseDTO;
import med.voll.api.medico.service.MedicoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
@AllArgsConstructor
public class MedicoController {

    private final MedicoService medicoService;

    @PostMapping
    public MedicoResponseDTO cadastrar(@Valid @RequestBody DadosCadastraisMedico medico) {
        return medicoService.saveMedico(medico);
    }


    @GetMapping
    public List<MedicoResponseDTO> getAllMedicos() {

        return medicoService.findAllMedico();
    }

    @PutMapping("/{id}")
    public MedicoResponseDTO updateMedico(@PathVariable Long id, @Valid @RequestBody MedicoPutRequestDTO medicoNovosDados){
        return medicoService.updateSomeDatasFromMedico(id,medicoNovosDados);
    }


    @DeleteMapping("/{id}")
    public void deleteMedico(@PathVariable Long id){
        medicoService.deleteMedico(id);
    }

    @GetMapping("/actived-medicos")
    public List<MedicoResponseDTO> findOnlyActivedMedicos() {
        return medicoService.findOnlyActivedMedicos();
    }


    @GetMapping("/desabled-medicos")
    public List<MedicoResponseDTO> findOnlyDesabledMedicos() {
        return medicoService.findOnlyDesactivedMedicos();
    }


}
