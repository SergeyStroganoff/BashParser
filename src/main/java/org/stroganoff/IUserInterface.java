package org.stroganoff;

import org.stroganoff.exceptions.UserInterfaceException;

import java.io.BufferedReader;

public interface IUserInterface {

    String getStringFromUser(BufferedReader reader) throws UserInterfaceException;

    void showInputMessage(String inputMessage);

    void showOutputMessage(String resultString);

    void showErrorMessage(String errorExpression);
}
