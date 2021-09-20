package org.stroganoff;

import org.stroganoff.exceptions.ContentManagerException;
import org.stroganoff.exceptions.HTMLParserException;

public interface Content {

    StringBuilder getAllContent() throws ContentManagerException;

    String getBashQuote(String contentString) throws HTMLParserException;
}
