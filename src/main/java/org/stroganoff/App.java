package org.stroganoff;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.stroganoff.exceptions.ContentManagerException;
import org.stroganoff.exceptions.HTMLParserException;
import org.stroganoff.exceptions.UserInterfaceException;
import org.stroganoff.impl.ContentManager;
import org.stroganoff.impl.UserInterface;
import org.stroganoff.util.StringValidator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * bash.im Quotes parser.
 *
 * @author Sergey Stroganov
 */
public class App {
    private static final Logger loggerApp = Logger.getLogger(App.class);
    public static final String START_PROGRAM_LOG_MESSAGE = "Start program was successful";
    public static final String BASH_URL = "https://bash.im/quote/";
    public static final String ERROR_ACTION_MESSAGE = "выполнение программы будет прервано - ";
    public static final String WRONG_INPUT_STRING_MESSAGE = "Введенная строка не является номером цитаты \n Попробуйте еще раз";
    public static final String INPUT_MESSAGE = "номер цитаты, для выхода 'q'";

    public static void main(String[] args) {
        loggerApp.setLevel(Level.INFO);
        loggerApp.info(START_PROGRAM_LOG_MESSAGE);
        IUserInterface userInterface = new UserInterface();
        String quoteNumber = null;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            userInterface.showInputMessage(INPUT_MESSAGE);
            try {
                quoteNumber = userInterface.getStringFromUser(bufferedReader);
            } catch (UserInterfaceException e) {
                e.printStackTrace();
                userInterface.showErrorMessage(ERROR_ACTION_MESSAGE + e.getMessage());
                System.exit(1);
            }
            if ("q".equals(quoteNumber)) {
                break;
            }
            if (StringValidator.isStringNumberQuote(quoteNumber)) {
                String quoteURL = BASH_URL + quoteNumber;
                Content content = new ContentManager(quoteURL);
                try {
                    StringBuilder stringBufferContent = content.getAllContent();
                    loggerApp.info("successfully have got all page content from " + quoteURL);
                    String quote = content.getBashQuote(stringBufferContent.toString());
                    loggerApp.info("successfully have got quote " + quote);
                    userInterface.showOutputMessage(quote);
                } catch (ContentManagerException | HTMLParserException e) {
                    userInterface.showErrorMessage(ERROR_ACTION_MESSAGE + e.getMessage());
                    System.exit(1);
                }
            } else {
                userInterface.showErrorMessage(WRONG_INPUT_STRING_MESSAGE);
            }
        }
    }
}
