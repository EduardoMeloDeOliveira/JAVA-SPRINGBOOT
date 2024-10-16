package med.voll.api.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import med.voll.api.dto.DadosCadastraisMedico;
import med.voll.api.dto.MedicoPutRequestDTO;
import med.voll.api.dto.MedicoResponseDTO;
import med.voll.api.entity.Medico;
import med.voll.api.service.MedicoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
}
