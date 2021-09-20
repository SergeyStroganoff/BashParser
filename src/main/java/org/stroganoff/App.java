package org.stroganoff;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.stroganoff.exceptions.UserInterfaceException;
import org.stroganoff.impl.FileInputStreamReader;
import org.stroganoff.impl.UserInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * bash.im Quotes parser.
 *
 * @author Sergey Stroganov
 */
public class App {
    private static final Logger loggerApp = Logger.getLogger(FileInputStreamReader.class);
    public static final String START_PROGRAM_LOG_MESSAGE = "Start program was successful";

    public static void main(String[] args) {
        loggerApp.setLevel(Level.INFO);
        loggerApp.info(START_PROGRAM_LOG_MESSAGE);
        IUserInterface userInterface = new UserInterface();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            userInterface.getStringFromUser(bufferedReader);
        } catch (UserInterfaceException | IOException e) {
            e.printStackTrace();
        }

    }
}
