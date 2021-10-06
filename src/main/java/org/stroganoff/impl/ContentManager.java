package org.stroganoff.impl;

import org.apache.log4j.Logger;
import org.stroganoff.Content;
import org.stroganoff.InputStreamResource;
import org.stroganoff.exceptions.ContentManagerException;
import org.stroganoff.exceptions.FileInputStreamReaderException;
import org.stroganoff.exceptions.HTMLParserException;
import org.stroganoff.exceptions.URLInputStreamGetException;
import org.stroganoff.util.HTMLParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ContentManager implements Content {
    private static final Logger logger = Logger.getLogger(ContentManager.class);
    private static final String ERROR_GET_ALL_CONTENT = "Fixed Error getAllContent";
    InputStreamResource inputStreamResource = new URLInputStreamReader();
    String quoteURL;

    public ContentManager(String quoteURL) {
        this.quoteURL = quoteURL;
    }

    @Override
    public StringBuilder getAllContent() throws ContentManagerException {
        StringBuilder stringBuilder = new StringBuilder();
        String inputLine;
        try (InputStreamReader inputStreamReader = inputStreamResource.getResourceInputStream(quoteURL);
             BufferedReader in = new BufferedReader(inputStreamReader)) {
            while ((inputLine = in.readLine()) != null) {
                stringBuilder.append(inputLine);
            }
        } catch (IOException | FileInputStreamReaderException | URLInputStreamGetException e) {
            logger.error(ERROR_GET_ALL_CONTENT + e.getMessage());
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
