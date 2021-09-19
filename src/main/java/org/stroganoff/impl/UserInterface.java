package org.stroganoff.impl;

import org.stroganoff.IUserInterface;

import java.io.BufferedReader;
import java.io.IOException;

public class UserInterface implements IUserInterface {

    private static final String INPUT_MESSAGE = "Введите в терминале ";
    private static final String OUTPUT_MESSAGE = "Выводим результат поиска: %n ";
    private static final String ERROR_MESSAGE = "Произошла ошибка: ";

    @Override
    public String getStringFromUser(BufferedReader reader) {
        String expressionString = " ";
        try {
            expressionString = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
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
