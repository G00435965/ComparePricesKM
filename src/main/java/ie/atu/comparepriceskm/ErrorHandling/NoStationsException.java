package ie.atu.comparepriceskm.ErrorHandling;

public class NoStationsException extends RuntimeException {
    public NoStationsException(String message) {
        super(message);
    }
}
