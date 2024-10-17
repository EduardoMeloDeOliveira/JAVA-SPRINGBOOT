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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorFieldsDTO>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        List<FieldError> fieldError = ex.getFieldErrors();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                fieldError.stream()
                        .map(ErrorFieldsDTO::new)
                        .collect(Collectors.toList())
        );
    }

    private record ErrorFieldsDTO(String field, String message) {

        public ErrorFieldsDTO(FieldError fieldError) {
            this(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }
}
