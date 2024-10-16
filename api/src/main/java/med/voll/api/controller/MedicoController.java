package med.voll.api.controller;

import lombok.AllArgsConstructor;
import med.voll.api.dto.DadosCadastraisMedico;
import med.voll.api.entity.Medico;
import med.voll.api.service.MedicoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
@AllArgsConstructor
public class MedicoController {

    private final MedicoService medicoService;

    @PostMapping
    public Medico cadastrar(@RequestBody DadosCadastraisMedico medico) {

        return medicoService.saveMedico(medico);
    }
}
