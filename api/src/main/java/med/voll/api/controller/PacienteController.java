package med.voll.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.api.domain.paciente.DTO.DadosCadastraisPacientes;
import med.voll.api.domain.paciente.DTO.PacientePutRequestDTO;
import med.voll.api.domain.paciente.DTO.PacienteResponseDTO;
import med.voll.api.domain.paciente.service.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<PacienteResponseDTO> savePaciente(@RequestBody @Valid DadosCadastraisPacientes dadosCadastraisPacientes) {

        PacienteResponseDTO pacienteResponseDTO = pacienteService.savePaciente(dadosCadastraisPacientes);
        return ResponseEntity.created(null).body(pacienteResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> updatePaciente(@PathVariable Long id, @RequestBody @Valid PacientePutRequestDTO pacienteData) {

        PacienteResponseDTO pacienteResponseDTO = pacienteService.updatePaciente(id, pacienteData);

        if (pacienteResponseDTO == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(pacienteResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<PacienteResponseDTO>> getAllPacientes() {

        List<PacienteResponseDTO> pacienteResponseDTOS = pacienteService.getAllPacientes();

        if (pacienteResponseDTOS.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(pacienteResponseDTOS);
    }

    @GetMapping("/actived-pacientes")
    public ResponseEntity<List<PacienteResponseDTO>> getActivePacientes() {

        List<PacienteResponseDTO> pacienteResponseDTOS = pacienteService.getActivePacientes();

        if (pacienteResponseDTOS.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(pacienteResponseDTOS);
    }

    @GetMapping("/disabled-pacientes")
    public ResponseEntity<List<PacienteResponseDTO>> getDisabledPacientes() {

        List<PacienteResponseDTO> pacienteResponseDTOS = pacienteService.getDesabledPacientes();

        if (pacienteResponseDTOS.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(pacienteResponseDTOS);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaciente(@PathVariable Long id) {

       PacienteResponseDTO pacienteResponseDTO = pacienteService.deletePaciente(id);

       if (pacienteResponseDTO == null) {
           return ResponseEntity.notFound().build();
       }

       return ResponseEntity.noContent().build();
    }

}
