package budko.metrowithpatterns.exceptions;

// исключение, которое выбрасывается, если поездок нет
public class NoTripsException extends Exception {
    public NoTripsException(String message) {
        super(message);
    }
}