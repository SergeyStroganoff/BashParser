package org.stroganoff.exceptions;

public class UserInterfaceException extends Exception {
    public UserInterfaceException() {
    }

    public UserInterfaceException(String message) {
        super(message);
    }

    public UserInterfaceException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserInterfaceException(Throwable cause) {
        super(cause);
    }
}
