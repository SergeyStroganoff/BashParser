package org.stroganoff.impl;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.stroganoff.IUserInterface;
import org.stroganoff.exceptions.UserInterfaceException;

import java.io.BufferedReader;
import java.io.IOException;

public class UserInterface implements IUserInterface {

    private static final String INPUT_MESSAGE = "Введите в терминале ";
    private static final String OUTPUT_MESSAGE = "Выводим результат поиска: \n";
    private static final String ERROR_MESSAGE = "Произошла ошибка: ";
    private static final Logger logger = Logger.getLogger(UserInterface.class);

    @Override
    public String getStringFromUser(BufferedReader reader) throws UserInterfaceException {
        logger.setLevel(Level.ERROR);
        String expressionString;
        try {
            expressionString = reader.readLine();
        } catch (IOException e) {
            logger.error("Input String Error in " + UserInterface.class, e);
            throw new UserInterfaceException(e);
        }
        return expressionString;
    }

    @Override
    public void showInputMessage(String inputMessagePartTwo) {
        System.out.println(INPUT_MESSAGE + inputMessagePartTwo);
    }

    @Override
    public void showOutputMessage(String resultString) {
        System.out.println(OUTPUT_MESSAGE + resultString);
    }

    @Override
    public void showErrorMessage(String errorExpression) {
        System.out.println(ERROR_MESSAGE + errorExpression);
    }
}
