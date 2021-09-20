package org.stroganoff;

import org.stroganoff.exceptions.FileInputStreamReaderException;
import org.stroganoff.exceptions.URLInputStreamGetException;

import java.io.InputStreamReader;

public interface InputStreamResource {

    /**
     * @param resource - url address
     * @return - stream of html page
     */
    InputStreamReader getResourceInputStream(String resource) throws URLInputStreamGetException, FileInputStreamReaderException;
}
