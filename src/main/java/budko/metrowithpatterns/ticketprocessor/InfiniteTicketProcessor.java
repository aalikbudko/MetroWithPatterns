package budko.metrowithpatterns.ticketprocessor;

import budko.metrowithpatterns.checks.*;
import budko.metrowithpatterns.ticket.*;
import budko.metrowithpatterns.exceptions.*;

import java.time.LocalDateTime;

public class InfiniteTicketProcessor extends AbstractTicketProcessor {

    @Override
    protected void checkTicket(Ticket ticket, TicketType transportType) throws NoTripsException, ExpiredTicketException, InvalidTicketTypeException {
        InfiniteTicket infiniteTicket = (InfiniteTicket) ticket;
        if (infiniteTicket.getExpirationDate().isBefore(LocalDateTime.now().toLocalDate())) {
            throw new ExpiredTicketException("The ticket is expired.");
        }

        // Implement chain of responsibility for checks
        CheckHandler handler = new InvalidTicketTypeCheckHandler(
                new ReuseWithin90MinutesCheckHandler(null)
        );
        handler.handle(ticket, transportType);
    }

    @Override
    protected void deductTrip(Ticket ticket) {
        // No need to deduct trips for infinite tickets
    }

    @Override
    protected void setLastUsedTime(Ticket ticket) {
        ticket.setLastUsed(LocalDateTime.now());
    }
}