package org.stroganoff.exceptions;

public class ContentManagerException extends Exception {
    public ContentManagerException() {
    }

    public ContentManagerException(String message) {
        super(message);
    }

    public ContentManagerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ContentManagerException(Throwable cause) {
        super(cause);
    }
}
