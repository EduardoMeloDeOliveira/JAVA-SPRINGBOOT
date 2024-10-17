package med.voll.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.api.paciente.DTO.DadosCadastraisPacientes;
import med.voll.api.paciente.DTO.PacientePutRequestDTO;
import med.voll.api.paciente.DTO.PacienteResponseDTO;
import med.voll.api.paciente.service.PacienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    @PostMapping
    public PacienteResponseDTO savePaciente(@RequestBody @Valid DadosCadastraisPacientes dadosCadastraisPacientes) {
        return pacienteService.savePaciente(dadosCadastraisPacientes);
    }

    @PutMapping("/{id}")
    public PacienteResponseDTO updatePaciente(@PathVariable Long id, @RequestBody @Valid PacientePutRequestDTO pacienteData) {
        return pacienteService.updatePaciente(id, pacienteData);
    }

    @GetMapping
    public List<PacienteResponseDTO> getAllPacientes() {
        return pacienteService.getAllPacientes();
    }

    @GetMapping("/actived-pacientes")
    public List<PacienteResponseDTO> getActivePacientes() {
        return pacienteService.getActivePacientes();
    }

    @GetMapping("/disabled-pacientes")
    public List<PacienteResponseDTO> getDisabledPacientes() {
        return pacienteService.getDesabledPacientes();
    }

    @DeleteMapping("/{id}")
    public void deletePaciente(@PathVariable Long id) {
        pacienteService.deletePaciente(id);
    }

}
