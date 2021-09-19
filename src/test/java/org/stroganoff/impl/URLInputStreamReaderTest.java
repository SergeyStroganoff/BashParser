package org.stroganoff.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.stroganoff.exceptions.URLInputStreamGetException;

import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class URLInputStreamReaderTest {

    public static final String HTTPS_YANDEX_RU = "https://yandex.ru/";

    @InjectMocks
    URLInputStreamReader inputStreamReader;

    @Test
    void getResourceInputStreamTestOnYandex() throws URLInputStreamGetException {
        //GIVEN
        InputStreamReader actualInputStreamReader;
        //WHEN
        actualInputStreamReader = inputStreamReader.getResourceInputStream(HTTPS_YANDEX_RU);
        //THEN
        assertNotNull(actualInputStreamReader);
    }


}