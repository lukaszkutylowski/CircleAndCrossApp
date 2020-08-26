package LukaszKutylowski.CircleAndCross;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.Assert.*;

public class PrintServiceTest {

    PrintService service;
    OutputStream outputStream;
    PrintStream printStream;

    @Before
    public void setUp() {
        service = new PrintService();
        outputStream = new ByteArrayOutputStream();
        printStream = new PrintStream(outputStream);
        System.setOut(printStream);
    }

    @Test
    public void should_print_choose_player() {
        //given
        final String MESSAGE_CHOOSE_PLAYER = "# Pierwszy gracz: O czy X ?   #";
        final String[][] testFields = {
                {" ", " ", " "},
                {" ", " ", " "},
                {" ", " ", " "}};
        final String expectedMessage =
                "###############################\r\n" +
                "#     GRA KÓŁKO I KRZYŻYK     #\r\n" +
                "# Pierwszy gracz: O czy X ?   #\r\n" +
                "#                             #\r\n" +
                "#            |   |            #\r\n" +
                "#          - | - | -          #\r\n" +
                "#            |   |            #\r\n" +
                "#          - | - | -          #\r\n" +
                "#            |   |            #\r\n" +
                "#                             #\r\n" +
                "###############################\r\n";
        //when
        PrintService.printGame(testFields, MESSAGE_CHOOSE_PLAYER);
        String actualMessage = outputStream.toString();
        //then
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void should_print_message_column() {
        //given
        final String expectedMessage = "  Wprowadź numer kolumny: ";
        //when
        PrintService.printMessageColumn();
        String actualMessage = outputStream.toString();
        //then
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void should_print_message_row() {
        //given
        final String expectedMessage = "  Wprowadź numer wiersza: ";
        //when
        PrintService.printMessageRow();
        String actualMessage = outputStream.toString();
        //then
        assertEquals(expectedMessage, actualMessage);
    }
}