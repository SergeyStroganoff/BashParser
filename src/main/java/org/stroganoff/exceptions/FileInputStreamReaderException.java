package org.stroganoff.exceptions;

public class FileInputStreamReaderException extends Exception {

    public FileInputStreamReaderException() {
    }

    public FileInputStreamReaderException(String message) {
        super(message);
    }

    public FileInputStreamReaderException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileInputStreamReaderException(Throwable cause) {
        super(cause);
    }

}
