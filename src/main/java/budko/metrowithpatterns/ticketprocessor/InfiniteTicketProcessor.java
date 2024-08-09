package budko.metrowithpatterns.ticketprocessor;

import budko.metrowithpatterns.checks.*;
import budko.metrowithpatterns.ticket.*;
import budko.metrowithpatterns.exceptions.*;

import java.time.LocalDateTime;

public class InfiniteTicketProcessor extends AbstractTicketProcessor {

    @Override
    protected boolean checkTicket(Ticket ticket, TicketType transportType) throws NoTripsException, ExpiredTicketException, InvalidTicketTypeException, ReuseWithin90MinutesException {
        InfiniteTicket infiniteTicket = (InfiniteTicket) ticket;
        if (infiniteTicket.getExpirationDate().isBefore(LocalDateTime.now().toLocalDate())) {
            throw new ExpiredTicketException("The ticket is expired.");
        }

        // внедрение цепочки ответственности
        CheckHandler handler = new InvalidTicketTypeCheckHandler(
                new ReuseWithin90MinutesCheckHandler(null)
        );
       return handler.handle(ticket, transportType);
    }

    @Override
    protected void deductTrip(Ticket ticket) {
    }

    @Override
    protected void setLastUsedTime(Ticket ticket) {
        ticket.setLastUsed(LocalDateTime.now());
    }
}