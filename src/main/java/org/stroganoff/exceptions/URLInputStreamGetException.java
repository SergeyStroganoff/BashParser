package org.stroganoff.exceptions;

public class URLInputStreamGetException extends Exception {

    public URLInputStreamGetException() {
    }

    public URLInputStreamGetException(String message) {
        super(message);
    }

    public URLInputStreamGetException(String message, Throwable cause) {
        super(message, cause);
    }

    public URLInputStreamGetException(Throwable cause) {
        super(cause);
    }
}
