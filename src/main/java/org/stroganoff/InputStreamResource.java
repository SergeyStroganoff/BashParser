package org.stroganoff;

import org.stroganoff.exceptions.FileInputStreamReaderException;
import org.stroganoff.exceptions.URLInputStreamGetException;

import java.io.InputStreamReader;

public interface InputStreamResource {

    /**
     * @param resource
     * @return
     */
    InputStreamReader getResourceInputStream(String resource) throws URLInputStreamGetException, FileInputStreamReaderException;
}
