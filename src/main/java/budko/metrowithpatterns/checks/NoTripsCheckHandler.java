package budko.metrowithpatterns.checks;

import budko.metrowithpatterns.exceptions.*;
import budko.metrowithpatterns.ticket.*;

public class NoTripsCheckHandler extends CheckHandler {

    public NoTripsCheckHandler(CheckHandler next) {
        super(next);
    }

    @Override
    public void handle(Ticket ticket, TicketType transportType) throws NoTripsException, InvalidTicketTypeException, ExpiredTicketException, ReuseWithin90MinutesException {
        if (ticket.getTrips() <= 0) {
            throw new NoTripsException("No trips left on the ticket.");
        }
        super.handle(ticket, transportType);
    }
}