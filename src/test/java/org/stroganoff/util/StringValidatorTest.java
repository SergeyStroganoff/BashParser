package org.stroganoff.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringValidatorTest {
    @Test
    void isStringNumberQuote_InputNumber_ReturnTrue() {
        // GIVEN
        String test = "123";
        // WHEN
        // THEN
        Assertions.assertTrue(StringValidator.isStringNumberQuote(test));
    }
}