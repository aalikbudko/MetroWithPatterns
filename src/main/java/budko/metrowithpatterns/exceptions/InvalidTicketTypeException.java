package budko.metrowithpatterns.exceptions;

//исключение, которое выбрасывается, если используетсяне тот тип билета
public class InvalidTicketTypeException extends Exception {
    public InvalidTicketTypeException(String message) {
        super(message);
    }
}