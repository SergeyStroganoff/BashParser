package org.stroganoff.impl;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.stroganoff.InputStreamResource;
import org.stroganoff.exceptions.FileInputStreamReaderException;

import java.io.*;

public class FileInputStreamReader implements InputStreamResource {
    private static final Logger logger = Logger.getLogger(FileInputStreamReader.class);
    public static final String ERROR_GET_STREAM_FROM_FILE = "Error get stream from file ";

    @Override
    public InputStreamReader getResourceInputStream(String resource) throws FileInputStreamReaderException {

        File file = new File(resource);
        InputStreamReader inputStreamReader;
        logger.setLevel(Level.ERROR);
        try {
            InputStream input = new FileInputStream(file);
            inputStreamReader = new InputStreamReader(input);
        } catch (FileNotFoundException e) {
            logger.error(ERROR_GET_STREAM_FROM_FILE + resource, e);
            throw new FileInputStreamReaderException(ERROR_GET_STREAM_FROM_FILE, e);
        }
        return inputStreamReader;
    }
}
