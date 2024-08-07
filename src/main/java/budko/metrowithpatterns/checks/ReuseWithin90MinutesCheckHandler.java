package budko.metrowithpatterns.checks;

import budko.metrowithpatterns.exceptions.ExpiredTicketException;
import budko.metrowithpatterns.exceptions.InvalidTicketTypeException;
import budko.metrowithpatterns.exceptions.NoTripsException;
import budko.metrowithpatterns.ticket.*;

import java.time.Duration;
import java.time.LocalDateTime;


public class ReuseWithin90MinutesCheckHandler extends CheckHandler {

    public ReuseWithin90MinutesCheckHandler(CheckHandler next) {
        super(next);
    }

    @Override
    public void handle(Ticket ticket, TicketType transportType) throws InvalidTicketTypeException, ExpiredTicketException, NoTripsException {
        if (ticket.getLastUsed() != null && Duration.between(ticket.getLastUsed(), LocalDateTime.now()).toMinutes() <= 90) {
            // No need to deduct trips if reused within 90 minutes
            return;
        }
        super.handle(ticket, transportType);
    }
}