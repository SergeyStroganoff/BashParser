package org.stroganoff.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.stroganoff.exceptions.UserInterfaceException;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UserInterfaceTest {

    public static final String INPUT_TEST_STRING = "Введите в терминале ";
    String ERROR_MESSAGE = "Произошла ошибка: ";
    String OUTPUT_MESSAGE = "Выводим результат поиска: \n ";
    @InjectMocks
    UserInterface userInterface;

    @Test
    void getStringFromUser_Return_TestString() throws IOException, UserInterfaceException {
        // GIVEN
        String expectedString = "test";
        BufferedReader reader = Mockito.mock(BufferedReader.class);
        Mockito.when(reader.readLine()).thenReturn("test");
        // WHEN
        String actualString = userInterface.getStringFromUser(reader);
        // THEN
        assertEquals(expectedString, actualString);
    }

    @Test
    void showInputMessageTest() {
        // GIVEN
        String expected = INPUT_TEST_STRING + "\r\n";
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(bos, true);
        PrintStream oldStream = System.out;
        System.setOut(printStream);
        // WHEN
        userInterface.showInputMessage("");
        String actual = bos.toString(StandardCharsets.UTF_8);
        System.setOut(oldStream);
        // THEN
        assertEquals(expected, actual);
    }

    @Test
    void showOutputMessageTest() {
        // GIVEN
        String expected = OUTPUT_MESSAGE + "\r\n";
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(bos, true);
        PrintStream oldStream = System.out;
        System.setOut(printStream);
        // WHEN
        userInterface.showOutputMessage("");
        String actual = bos.toString(StandardCharsets.UTF_8);
        System.setOut(oldStream);
        // THEN
        assertEquals(expected, actual);
    }

    @Test
    void showErrorMessageTest() throws IOException {
        // GIVEN
        String expected = ERROR_MESSAGE + "\r\n";
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(bos, true);
        PrintStream oldStream = System.out;
        System.setOut(printStream);
        // WHEN
        userInterface.showErrorMessage("");
        String actual = bos.toString(StandardCharsets.UTF_8);
        System.setOut(oldStream);
        // THEN
        assertEquals(expected, actual);


    }
}