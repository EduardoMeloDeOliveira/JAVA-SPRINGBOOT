package med.voll.api.domain.medico.exception.handler;

import med.voll.api.domain.medico.exception.MedicoNotFoundExecption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class MedicoExceptionHandler {

    @ExceptionHandler(MedicoNotFoundExecption.class)
    public ResponseEntity<String> handlerMedicoNotFoundExecption(MedicoNotFoundExecption ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}
