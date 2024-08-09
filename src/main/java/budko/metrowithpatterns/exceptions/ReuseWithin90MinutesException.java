package budko.metrowithpatterns.exceptions;

import budko.metrowithpatterns.checks.ReuseWithin90MinutesCheckHandler;

public class ReuseWithin90MinutesException extends Exception{
    public ReuseWithin90MinutesException(String message) {super(message);}
}
