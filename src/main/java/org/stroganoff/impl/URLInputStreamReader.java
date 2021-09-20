package org.stroganoff.impl;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.stroganoff.InputStreamResource;
import org.stroganoff.exceptions.URLInputStreamGetException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class URLInputStreamReader implements InputStreamResource {
    private static final Logger logger = Logger.getLogger(URLInputStreamReader.class);
    private static final String ERROR_IO_WITH_CONNECT_TO = "Fixed error IO with connect to: ";

    @Override
    public InputStreamReader getResourceInputStream(String resource) throws URLInputStreamGetException {
        URL url;
        InputStreamReader inputStreamReader;
        logger.setLevel(Level.ERROR);
        try {
            url = new URL(resource);
            InputStream input = url.openStream();
            inputStreamReader = new InputStreamReader(input);
        } catch (IOException e) {
            logger.error(ERROR_IO_WITH_CONNECT_TO + resource, e);
            throw new URLInputStreamGetException(e);
        }
        return inputStreamReader;
    }

}
