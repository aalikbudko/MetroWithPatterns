package budko.metrowithpatterns.ticketprocessor;

import budko.metrowithpatterns.exceptions.*;
import budko.metrowithpatterns.ticket.*;


public abstract class AbstractTicketProcessor {

    public void processTicket(Ticket ticket, TicketType transportType) throws NoTripsException, ExpiredTicketException, InvalidTicketTypeException, ReuseWithin90MinutesException {
        checkTicket(ticket, transportType);
        deductTrip(ticket);
        setLastUsedTime(ticket);
    }

    protected abstract void checkTicket(Ticket ticket, TicketType transportType) throws NoTripsException, ExpiredTicketException, InvalidTicketTypeException, ReuseWithin90MinutesException;

    protected abstract void deductTrip(Ticket ticket) throws NoTripsException;

    protected abstract void setLastUsedTime(Ticket ticket);
}