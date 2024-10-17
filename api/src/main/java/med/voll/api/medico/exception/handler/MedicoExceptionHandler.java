package med.voll.api.medico.exception.handler;

import med.voll.api.medico.exception.MedicoNotFoundExecption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MedicoExceptionHandler {

    @ExceptionHandler(MedicoNotFoundExecption.class)
    public ResponseEntity<String> handlerMedicoNotFoundExecption(MedicoNotFoundExecption ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
