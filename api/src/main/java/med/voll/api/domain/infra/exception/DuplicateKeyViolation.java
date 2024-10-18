package med.voll.api.domain.infra.exception;

public class DuplicateKeyViolation extends RuntimeException{

    public DuplicateKeyViolation(String message) {
        super(message);
    }
}
