package projects.bootcamp.domain.exception;

public class NegativeNotAllwedException extends RuntimeException {
    public NegativeNotAllwedException(String message){
        super(message);
    }
}
