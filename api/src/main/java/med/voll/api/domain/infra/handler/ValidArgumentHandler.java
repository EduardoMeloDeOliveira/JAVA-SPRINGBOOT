package med.voll.api.domain.infra.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ValidArgumentHandler {

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
