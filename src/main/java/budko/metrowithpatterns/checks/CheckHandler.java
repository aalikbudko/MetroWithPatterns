package budko.metrowithpatterns.checks;

import budko.metrowithpatterns.exceptions.*;
import budko.metrowithpatterns.ticket.*;

public abstract class CheckHandler {
    private CheckHandler next;

    public CheckHandler(CheckHandler next) {
        this.next = next;
    }

    public void handle(Ticket ticket, TicketType transportType) throws NoTripsException, ExpiredTicketException, InvalidTicketTypeException, ReuseWithin90MinutesException {
        if (next != null) {
            next.handle(ticket, transportType);
        }
    }
}
