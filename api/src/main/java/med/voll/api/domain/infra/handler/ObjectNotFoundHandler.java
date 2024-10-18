package med.voll.api.domain.infra.handler;

import med.voll.api.domain.infra.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ObjectNotFoundHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<String> objectNotFound(ObjectNotFoundException e) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
