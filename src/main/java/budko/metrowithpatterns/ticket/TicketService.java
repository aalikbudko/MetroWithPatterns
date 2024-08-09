package budko.metrowithpatterns.ticket;

import budko.metrowithpatterns.ticketprocessor.*;
import budko.metrowithpatterns.exceptions.*;

public class TicketService {

    private TicketProcessorFactory factory = new TicketProcessorFactory();

    public Ticket checkAndDeductTrip(Ticket ticket, TicketType transportType) throws NoTripsException, ExpiredTicketException, InvalidTicketTypeException, ReuseWithin90MinutesException {
        AbstractTicketProcessor processor = factory.getProcessor(ticket);
        processor.processTicket(ticket, transportType);
        return ticket;
    }
}