package med.voll.api.paciente.exception.handler;

import med.voll.api.paciente.exception.PacienteNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PacienteExceptionHandler {


    @ExceptionHandler(PacienteNotFoundException.class)
    public ResponseEntity<String> handlerPacienteNotFoundException(PacienteNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}
