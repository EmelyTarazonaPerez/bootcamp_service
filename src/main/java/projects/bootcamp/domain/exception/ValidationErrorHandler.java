package projects.bootcamp.domain.exception;

public class ValidationErrorHandler extends RuntimeException{
    public ValidationErrorHandler(String message) {
        super(message);
    }
}
