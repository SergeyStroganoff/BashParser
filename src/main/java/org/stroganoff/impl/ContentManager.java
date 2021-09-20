package org.stroganoff.impl;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.stroganoff.Content;
import org.stroganoff.exceptions.ContentManagerException;
import org.stroganoff.exceptions.HTMLParserException;
import org.stroganoff.util.HTMLParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ContentManager implements Content {
    private static final Logger logger = Logger.getLogger(ContentManager.class);
    private static final String ERROR_GET_ALL_CONTENT = "Fixed Error getAllContent";
    public static final String SET_INPUT_STREAM_ERROR = "setInputStreamReader Error: attempt set null inputStreamReader";
    InputStreamReader inputStreamReader;

    public ContentManager(InputStreamReader inputStreamReader) {
        this.inputStreamReader = inputStreamReader;
    }

    public void setInputStreamReader(InputStreamReader inputStreamReader) throws ContentManagerException {
        if (inputStreamReader != null) {
            this.inputStreamReader = inputStreamReader;
        } else {
            logger.error(SET_INPUT_STREAM_ERROR);
            throw new ContentManagerException(SET_INPUT_STREAM_ERROR);
        }
    }

    @Override
    public StringBuilder getAllContent() throws ContentManagerException {
        logger.setLevel(Level.ERROR);
        if (inputStreamReader == null) {
            logger.error(ERROR_GET_ALL_CONTENT + "InputStreamIsNull");
            throw new ContentManagerException(ERROR_GET_ALL_CONTENT + "InputStreamIsNull");
        }
        StringBuilder stringBuilder = new StringBuilder();
        String inputLine;
        try (BufferedReader in = new BufferedReader(inputStreamReader)) {
            while ((inputLine = in.readLine()) != null) {
                stringBuilder.append(inputLine);
            }
        } catch (IOException e) {
            logger.error(ERROR_GET_ALL_CONTENT + "IOEXCEPTION");
            throw new ContentManagerException(ERROR_GET_ALL_CONTENT, e);
        }
        return stringBuilder;
    }

    // Вопрос - до каких уровней мы пробрасываем исключения где мы их обрабатываем при хорошей архитектуре
    @Override
    public String getBashQuote(String contentString) throws HTMLParserException {
        String startString = "</header>    <div class=\"quote__body\">";
        String endString = "<footer class=\"quote__footer\">";
        HTMLParser htmlParser = new HTMLParser(contentString);
        return htmlParser.getSubstring(startString, endString);
    }
}
