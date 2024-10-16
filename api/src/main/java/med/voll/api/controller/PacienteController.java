package med.voll.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.api.paciente.DTO.DadosCadastraisPacientes;
import med.voll.api.paciente.DTO.PacienteResponseDTO;
import med.voll.api.paciente.service.PacienteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    @PostMapping
    public PacienteResponseDTO savePaciente (@RequestBody @Valid DadosCadastraisPacientes dadosCadastraisPacientes){
        return pacienteService.savePaciente(dadosCadastraisPacientes);
    }


}
