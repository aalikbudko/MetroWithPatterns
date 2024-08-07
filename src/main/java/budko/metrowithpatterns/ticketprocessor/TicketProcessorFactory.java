package budko.metrowithpatterns.ticketprocessor;

import budko.metrowithpatterns.ticket.*;

public class TicketProcessorFactory {

    public AbstractTicketProcessor getProcessor(Ticket ticket) {
        if (ticket instanceof InfiniteTicket) {
            return new InfiniteTicketProcessor();
        } else {
            return new TicketProcessor();
        }
    }

    public AbstractTicketProcessor getProcessor(InfiniteTicket ticket) {
        return new InfiniteTicketProcessor();
    }
}