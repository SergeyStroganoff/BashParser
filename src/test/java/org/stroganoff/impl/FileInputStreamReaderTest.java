package org.stroganoff.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.stroganoff.exceptions.FileInputStreamReaderException;

import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class FileInputStreamReaderTest {

    @InjectMocks
    FileInputStreamReader inputStreamReader;

    @Test
    void getResourceInputStream() throws FileInputStreamReaderException {
        //GIVEN
        InputStreamReader actualInputStreamReader;
        //WHEN
        actualInputStreamReader = inputStreamReader.getResourceInputStream("src/test/resources/mockito-extensions/org.mockito.plugins.MockMaker");
        //THEN
        assertNotNull(actualInputStreamReader);
    }
}