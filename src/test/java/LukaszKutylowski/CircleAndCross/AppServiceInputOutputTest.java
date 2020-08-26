package LukaszKutylowski.CircleAndCross;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class AppServiceInputOutputTest {

    AppService service;

    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {
        service = new AppService();
        outputStream = new ByteArrayOutputStream();
    }

    @Test
    public void should_return_chosen_player() {
        //given
        final String expectedInput = "X";
        //when
        InputStream stream = new ByteArrayInputStream(expectedInput.getBytes());
        System.setIn(stream);
        String out = service.choosePlayer();
        //then
        assertEquals(expectedInput, out);
    }

    @Test
    public void should_set_coordinate() {
        //given
        final boolean testRow = true;
        final String testInput = "1";
        final Integer expectedOutput = 0;
        //when
        InputStream stream = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(stream);
        Integer actualCoordinate = service.setCoordinate(testRow);
        //then
        assertEquals(expectedOutput, actualCoordinate);
    }

    @Test
    public void should_set_column_and_row() {
        //given
        final int testRow = 0;
        final int testColumn = 0;
        final String[][] testFields = {
                {" ", " ", " "},
                {" ", " ", " "},
                {" ", " ", " "}};
        final String[][] expectedFields = {
                {"X", " ", " "},
                {" ", " ", " "},
                {" ", " ", " "}};
        final String testPlayer = "X";
        //when
        service.setColumnAndRow(testFields, testPlayer, testRow, testColumn);
        //then
        assertEquals(expectedFields, testFields);
    }
}