package org.stroganoff.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.stroganoff.App;
import org.stroganoff.Content;
import org.stroganoff.exceptions.ContentManagerException;

@ExtendWith(MockitoExtension.class)
class ContentManagerTest {

    @InjectMocks
    ContentManager contentManager;

    @Test
    void getAllContentTest_ReturnString() throws ContentManagerException {
        //GIVEN
        String quoteURL = App.BASH_URL + 1;
        //WHEN
        Content content = new ContentManager(quoteURL);
        StringBuilder actualStringBuilder = content.getAllContent();
        //THEN
        Assertions.assertEquals(55154, actualStringBuilder.toString().length());
    }
}