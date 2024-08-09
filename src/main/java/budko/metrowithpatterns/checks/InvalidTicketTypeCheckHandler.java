package budko.metrowithpatterns.checks;

import budko.metrowithpatterns.exceptions.*;
import budko.metrowithpatterns.ticket.*;

public class InvalidTicketTypeCheckHandler extends CheckHandler {

    public InvalidTicketTypeCheckHandler(CheckHandler next) {
        super(next);
    }

    @Override
    public boolean handle(Ticket ticket, TicketType transportType) throws InvalidTicketTypeException, ExpiredTicketException, NoTripsException, ReuseWithin90MinutesException {
        if (ticket.getType() != TicketType.BOTH && ticket.getType() != transportType) {
            return false;
            //throw new InvalidTicketTypeException("Ticket is not valid for this type of transport.");
        }
        return super.handle(ticket, transportType);

    }
}