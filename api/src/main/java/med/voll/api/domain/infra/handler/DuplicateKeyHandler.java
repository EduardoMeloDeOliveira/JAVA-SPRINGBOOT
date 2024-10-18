package med.voll.api.domain.infra.handler;

import med.voll.api.domain.infra.exception.DuplicateKeyViolation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DuplicateKeyHandler {

    @ExceptionHandler(DuplicateKeyViolation.class)
    public ResponseEntity<String> handlerDuplicateKeyException(DuplicateKeyViolation ex) {

        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());

    }
}
