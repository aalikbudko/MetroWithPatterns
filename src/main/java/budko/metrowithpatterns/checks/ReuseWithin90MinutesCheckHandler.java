package budko.metrowithpatterns.checks;

import budko.metrowithpatterns.exceptions.ExpiredTicketException;
import budko.metrowithpatterns.exceptions.InvalidTicketTypeException;
import budko.metrowithpatterns.exceptions.NoTripsException;
import budko.metrowithpatterns.exceptions.ReuseWithin90MinutesException;
import budko.metrowithpatterns.ticket.*;

import java.time.Duration;
import java.time.LocalDateTime;


public class ReuseWithin90MinutesCheckHandler extends CheckHandler {

    public ReuseWithin90MinutesCheckHandler(CheckHandler next) {
        super(next);
    }

    @Override
    public void handle(Ticket ticket, TicketType transportType) throws InvalidTicketTypeException, ExpiredTicketException, NoTripsException, ReuseWithin90MinutesException {
        if (ticket.getLastUsed() != null && Duration.between(ticket.getLastUsed(), LocalDateTime.now()).toMinutes() <= 90) {
            // не списываем, если не прошло 90 минут
            throw new ReuseWithin90MinutesException("Проходите");
        }
        super.handle(ticket, transportType);
    }
}