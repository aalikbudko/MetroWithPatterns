package budko.metrowithpatterns.checks;

import budko.metrowithpatterns.exceptions.*;
import budko.metrowithpatterns.ticket.*;

public abstract class CheckHandler {
    private CheckHandler next;

    public CheckHandler(CheckHandler next) {
        this.next = next;
    }

    public boolean handle(Ticket ticket, TicketType transportType) throws NoTripsException, ExpiredTicketException, InvalidTicketTypeException, ReuseWithin90MinutesException {
        if (next != null) {
            return next.handle(ticket, transportType);
        }
        return true;
    }
}
