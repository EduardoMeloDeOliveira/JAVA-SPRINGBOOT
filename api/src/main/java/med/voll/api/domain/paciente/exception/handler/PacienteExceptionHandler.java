package med.voll.api.domain.paciente.exception.handler;

import med.voll.api.domain.paciente.exception.PacienteNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class PacienteExceptionHandler {


    @ExceptionHandler(PacienteNotFoundException.class)
    public ResponseEntity<String> handlerPacienteNotFoundException(PacienteNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }


}
