package org.stroganoff.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.stroganoff.exceptions.HTMLParserException;

@ExtendWith(MockitoExtension.class)
class HTMLParserTest {

    @InjectMocks
    HTMLParser htmlParser;

    public static final String HTML_TEST_CONTENT = "<!DOCTYPE html>\n<!-- saved from url=(0025)https://bash.im/quote/467 -->" +
            "\n<html theme=\"light\" lang=\"ru\" data-controller=\"quote\" aside=\"true\">" +
            "<head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">";

    @Test
    void setContentString_NotHTML_TrowException() {
        //GIVEN
        String testString = "some string";
        Assertions.assertThrows(HTMLParserException.class, () -> htmlParser.setContentString(testString));

    }

    @Test
    void isContentHTML_Test_MustReturnTrue() throws HTMLParserException {
        // GIVEN
        String testContent = HTML_TEST_CONTENT;
        // WHEN
        // THEN
        Assertions.assertTrue(htmlParser.isContentHTML(HTML_TEST_CONTENT));
    }

    @Test
    void getSubstringFromNotHTMLContent_TrowExceptionTest() throws HTMLParserException {
        // GIVEN
        String simpleNotHTMLString = "abra";
        HTMLParser htmlParserTest = new HTMLParser(simpleNotHTMLString);
        // WHEN
        // THEN
        Assertions.assertThrows(HTMLParserException.class, () -> htmlParserTest.getSubstring("", ""));
    }

    @Test
    void getSubstringFromTestString_Returns_ExpectedString() throws HTMLParserException {
        // GIVEN
        String stringForTest = HTML_TEST_CONTENT;
        htmlParser.setContentString(stringForTest);
        String expectedString = "html";
        // WHEN
        String actual = htmlParser.getSubstring("!DOCTYPE ", " url");
        // THEN
        Assertions.assertEquals(expectedString, actual);
    }
}