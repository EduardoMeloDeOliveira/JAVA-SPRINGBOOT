package med.voll.api.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import med.voll.api.domain.medico.DTO.DadosCadastraisMedico;
import med.voll.api.domain.medico.DTO.MedicoPutRequestDTO;
import med.voll.api.domain.medico.DTO.MedicoResponseDTO;
import med.voll.api.domain.medico.service.MedicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
@AllArgsConstructor
public class MedicoController {

    private final MedicoService medicoService;

    @PostMapping
    public ResponseEntity<MedicoResponseDTO> cadastrar(@Valid @RequestBody DadosCadastraisMedico dadosCadastraisMedico) {

        MedicoResponseDTO medico = medicoService.saveMedico(dadosCadastraisMedico);
        return ResponseEntity.created(null).body(medico);
    }


    @GetMapping
    public ResponseEntity<List<MedicoResponseDTO>> getAllMedicos() {

        List<MedicoResponseDTO> medicoResponseDTOS = medicoService.findAllMedico();

        if (medicoResponseDTOS == null || medicoResponseDTOS.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(medicoResponseDTOS);

    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicoResponseDTO> updateMedico(@PathVariable Long id, @Valid @RequestBody MedicoPutRequestDTO medicoNovosDados) {

        MedicoResponseDTO medicoResponseDTO = medicoService.updateSomeDatasFromMedico(id, medicoNovosDados);

        if (medicoResponseDTO == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(medicoResponseDTO);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedico(@PathVariable Long id) {

        MedicoResponseDTO medicoResponseDTO = medicoService.deleteMedico(id);

        if (medicoResponseDTO == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();

    }

    @GetMapping("/actived-medicos")
    public ResponseEntity<List<MedicoResponseDTO>> findOnlyActivedMedicos() {

        List<MedicoResponseDTO> medicoResponseDTOS = medicoService.findOnlyActivedMedicos();

        if (medicoResponseDTOS.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(medicoResponseDTOS);
    }


    @GetMapping("/desabled-medicos")
    public ResponseEntity<List<MedicoResponseDTO>> findOnlyDesabledMedicos() {

        List<MedicoResponseDTO> medicoResponseDTOS = medicoService.findOnlyDesactivedMedicos();

        if (medicoResponseDTOS.isEmpty()) {
            return ResponseEntity.noContent().build();
        }


        return ResponseEntity.ok().body(medicoResponseDTOS);

    }


}
