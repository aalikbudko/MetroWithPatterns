package budko.metrowithpatterns.checks;

import budko.metrowithpatterns.exceptions.*;
import budko.metrowithpatterns.ticket.*;

public class NoTripsCheckHandler extends CheckHandler {

    public NoTripsCheckHandler(CheckHandler next) {
        super(next);
    }

    @Override
    public boolean handle(Ticket ticket, TicketType transportType) throws NoTripsException, InvalidTicketTypeException, ExpiredTicketException, ReuseWithin90MinutesException {
        if (ticket.getTrips() <= 0) {
            return false;
            //throw new NoTripsException("No trips left on the ticket.");
        }
        return super.handle(ticket, transportType);
    }
}