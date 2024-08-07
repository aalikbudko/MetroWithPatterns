package budko.metrowithpatterns.exceptions;

//просроченный бесконечный билет
public class ExpiredTicketException extends Exception {
    public ExpiredTicketException(String message) {
        super(message);
    }
}
