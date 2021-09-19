package org.stroganoff;

import java.io.InputStreamReader;

public interface InputStreamResource {

    InputStreamReader getResourceInputStream(String resource);
}
