package org.stroganoff.impl;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.stroganoff.Content;
import org.stroganoff.exceptions.ContentManagerException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ContentManager implements Content {
    private static final Logger logger = Logger.getLogger(ContentManager.class);
    private static final String ERROR_GET_ALL_CONTENT = "Fixed Error getAllContent";
    InputStreamReader inputStreamReader;

    public ContentManager(InputStreamReader inputStreamReader) {
        this.inputStreamReader = inputStreamReader;
    }

    @Override
    public StringBuilder getAllContent() throws ContentManagerException {
        logger.setLevel(Level.ERROR);
        StringBuilder stringBuilder = null;
        String inputLine;
        try (BufferedReader in = new BufferedReader(inputStreamReader)) {
            while ((inputLine = in.readLine()) != null) {
                stringBuilder.append(inputLine);
            }
        } catch (IOException e) {
            logger.error(ERROR_GET_ALL_CONTENT, e);
            throw new ContentManagerException(ERROR_GET_ALL_CONTENT, e);

        }
        return stringBuilder;
    }
}
