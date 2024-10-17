package med.voll.api.domain.exception;

public class DuplicateKeyViolation extends RuntimeException{

    public DuplicateKeyViolation(String message) {
        super(message);
    }
}
