package org.stroganoff.util;

import org.stroganoff.exceptions.HTMLParserException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLParser {
    public static final String DOCTYPE_HTML_REGEX = ".*<!doctype html>";
    public static final String ERROR_HTML_FORMAT_MESSAGE = "Попытка парсинга не HTML контента";
    String contentString;

    public HTMLParser(String contentString) {
        this.contentString = contentString;
    }

    public void setContentString(String contentString) throws HTMLParserException {
        if (isContentHTML(contentString)) {
            this.contentString = contentString;
        } else
            throw new HTMLParserException(ERROR_HTML_FORMAT_MESSAGE);
    }

    boolean isContentHTML(String validatingString) {
        Pattern pattern = Pattern.compile(DOCTYPE_HTML_REGEX);
        Matcher matcher = pattern.matcher(validatingString);
        return matcher.lookingAt();
    }

    public String getSubstring(String startString, String endString) throws HTMLParserException {
        if (!isContentHTML(contentString)) {
            throw new HTMLParserException(ERROR_HTML_FORMAT_MESSAGE);
        }
        String subString;
        int startIndex = contentString.indexOf(startString);
        int endIndex = contentString.indexOf(endString);
        subString = contentString.substring(startIndex + startString.length(), endIndex);
        return replaceSymbols(subString);
    }

    private String replaceSymbols(String string) {

        return string
                .replaceAll("&lt", "<")
                .replaceAll("&gt", ">")
                .replaceAll("&quot", "\"")
                .replaceAll("<br ?/?>", "\n")
                .replaceAll(";", "")
                .replaceAll("</div>", "")
                .trim();
    }
}
