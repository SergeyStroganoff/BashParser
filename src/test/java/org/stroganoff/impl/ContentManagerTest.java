package org.stroganoff.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.stroganoff.Content;
import org.stroganoff.exceptions.ContentManagerException;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@ExtendWith(MockitoExtension.class)
class ContentManagerTest {

    @Mock
    InputStreamReader inputStreamReaderMock;

    @InjectMocks
    ContentManager contentManager;

    @Test
    void getAllContentTest_ReturnString() throws ContentManagerException {
        //GIVEN
        String testString = "test";
        InputStream stream = new ByteArrayInputStream(testString.getBytes(StandardCharsets.UTF_8));
        InputStreamReader inputStreamReader = new InputStreamReader(stream);
        //WHEN
        Content content = new ContentManager(inputStreamReader);
        StringBuilder actualStringBuilder = content.getAllContent();
        //THEN
        Assertions.assertEquals(testString, actualStringBuilder.toString());
    }

    @Test
    void setInputStreamReader_WhenSetNULL_ThrowException_Test() {
        //GIVEN
        InputStreamReader inputStreamReader = null;
        //WHEN
        //THEN
        Assertions.assertThrows(ContentManagerException.class, () -> contentManager.setInputStreamReader(inputStreamReader));
    }
}