package org.stroganoff;

import org.stroganoff.exceptions.ContentManagerException;

public interface Content {

    StringBuilder getAllContent() throws ContentManagerException;
}
