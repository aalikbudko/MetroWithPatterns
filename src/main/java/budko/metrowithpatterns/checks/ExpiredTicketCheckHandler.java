package budko.metrowithpatterns.checks;

import budko.metrowithpatterns.exceptions.*;
import budko.metrowithpatterns.ticket.*;

public class ExpiredTicketCheckHandler extends CheckHandler {

    public ExpiredTicketCheckHandler(CheckHandler next) {
        super(next);
    }

    @Override
    public void handle(Ticket ticket, TicketType transportType) throws ExpiredTicketException, InvalidTicketTypeException, NoTripsException {
        if (ticket instanceof InfiniteTicket) {
            InfiniteTicket infiniteTicket = (InfiniteTicket) ticket;
            if (infiniteTicket.getExpirationDate().isBefore(java.time.LocalDate.now())) {
                throw new ExpiredTicketException("The ticket is expired.");
            }
        }
        super.handle(ticket, transportType);
    }
}