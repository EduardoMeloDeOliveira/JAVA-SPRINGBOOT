package med.voll.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.api.domain.consulta.DTO.ConsultaReponseDTO;
import med.voll.api.domain.consulta.DTO.ConsultaRequestDTO;
import med.voll.api.domain.consulta.service.ConsultaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultas")
@RequiredArgsConstructor
public class ConsultaController {

    private final ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<ConsultaReponseDTO> createConsulta(@RequestBody @Valid ConsultaRequestDTO consulta) {

        ConsultaReponseDTO consultaReponseDTO = consultaService.createConsulta(consulta);

        return ResponseEntity.ok(consultaReponseDTO);
    }
}
