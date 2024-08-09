package budko.metrowithpatterns.ticketprocessor;

import java.time.LocalDateTime;
import budko.metrowithpatterns.checks.*;
import budko.metrowithpatterns.ticket.*;
import budko.metrowithpatterns.exceptions.*;

public class TicketProcessor extends AbstractTicketProcessor {

    @Override
    protected boolean checkTicket(Ticket ticket, TicketType transportType) throws NoTripsException, ExpiredTicketException, InvalidTicketTypeException, ReuseWithin90MinutesException {
        // внедрение цепочки ответственности
        CheckHandler handler = new ReuseWithin90MinutesCheckHandler(
                new InvalidTicketTypeCheckHandler(
                        new NoTripsCheckHandler(null)
                )
        );
       return handler.handle(ticket, transportType);
    }

    @Override
    protected void deductTrip(Ticket ticket) throws NoTripsException {
        if (ticket.getTrips() <= 0) {
            throw new NoTripsException("No trips left on the ticket.");
        }
        ticket.setTrips(ticket.getTrips() - 1);
    }

    @Override
    protected void setLastUsedTime(Ticket ticket) {
        ticket.setLastUsed(LocalDateTime.now());
    }
}