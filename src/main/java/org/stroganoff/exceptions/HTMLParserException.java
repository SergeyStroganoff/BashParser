package org.stroganoff.exceptions;

public class HTMLParserException extends Exception {
    public HTMLParserException() {
    }

    public HTMLParserException(String message) {
        super(message);
    }

    public HTMLParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public HTMLParserException(Throwable cause) {
        super(cause);
    }
}
