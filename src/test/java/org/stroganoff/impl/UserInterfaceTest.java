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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UserInterfaceTest {

    public static final String INPUT_TEST_STRING = "Введите в терминале";
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
        byte[] expected = INPUT_TEST_STRING.getBytes();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(bos, true);
        PrintStream oldStream = System.out;
        System.setOut(printStream);
        // WHEN
        userInterface.showInputMessage("");
        byte[] actualString = INPUT_TEST_STRING.getBytes();
        // THEN
        assertArrayEquals(expected, actualString);
        System.setOut(oldStream);
    }

    @Test
    void showOutputMessageTest() {
        // GIVEN
        byte[] expected = INPUT_TEST_STRING.getBytes();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(bos, true);
        PrintStream oldStream = System.out;
        System.setOut(printStream);
        // WHEN
        userInterface.showOutputMessage("");
        byte[] actualString = INPUT_TEST_STRING.getBytes();
        // THEN
        assertArrayEquals(expected, actualString);
        System.setOut(oldStream);
    }

    @Test
    void showErrorMessageTest() {
        // GIVEN
        byte[] expected = INPUT_TEST_STRING.getBytes();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(bos, true);
        PrintStream oldStream = System.out;
        System.setOut(printStream);
        // WHEN
        userInterface.showErrorMessage("");
        byte[] actualString = INPUT_TEST_STRING.getBytes();
        // THEN
        assertArrayEquals(expected, actualString);
        System.setOut(oldStream);
    }
}