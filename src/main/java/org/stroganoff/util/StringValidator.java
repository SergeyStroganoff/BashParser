package org.stroganoff.util;

public class StringValidator {

    static public boolean isStringNumberQuote(String inputString) {
        return inputString.matches("\\d{1,6}");
    }

}
