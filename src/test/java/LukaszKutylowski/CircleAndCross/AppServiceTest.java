package LukaszKutylowski.CircleAndCross;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class AppServiceTest {

    AppService service;
    PrintService printService;
    OutputStream outputStream;
    PrintStream printStream;

    @Before
    public void setUp() {
        service = new AppService();
        printService = new PrintService();
        outputStream = new ByteArrayOutputStream();
        printStream = new PrintStream(outputStream);
        System.setOut(printStream);
    }

    @Test
    public void should_show_game() {
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
        service.showGame(testFields, MESSAGE_CHOOSE_PLAYER);
        String actualMessage = outputStream.toString();
        //then
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void startGame() {
        //given
        final String[][] testFields = {
                {" ", " ", " "},
                {" ", " ", " "},
                {" ", " ", " "}};
        final String testPlayerOorX = "X";
        final String testMESSAGE_PLAYER_1st_HALF = "# Gracz: ";
        final String testMESSAGE_PLAYER_2nd_HALF = "                    #";
        final String expectedMessage =
                        "###############################\r\n" +
                        "#     GRA KÓŁKO I KRZYŻYK     #\r\n" +
                        "# Gracz: X                    #\r\n" +
                        "#                             #\r\n" +
                        "#            |   |            #\r\n" +
                        "#          - | - | -          #\r\n" +
                        "#            |   |            #\r\n" +
                        "#          - | - | -          #\r\n" +
                        "#            |   |            #\r\n" +
                        "#                             #\r\n" +
                        "###############################\r\n";
        //when
        service.startGame(testFields, testPlayerOorX, testMESSAGE_PLAYER_1st_HALF, testMESSAGE_PLAYER_2nd_HALF);
        String actualMessage = outputStream.toString();
        //then
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void should_check_draw_when_true() {
        //given
        final String[][] testFields = {
                {"X", "X", "O"},
                {"O", "O", "X"},
                {"X", "O", "X"}};
        final String testMESSAGE_DRAW = "#           REMIS!            #";
        final boolean expectedDraw = true;
        //when
        boolean actualDraw = AppService.checkDraw(testFields, testMESSAGE_DRAW);
        //then
        assertEquals(expectedDraw, actualDraw);
    }

    @Test
    public void should_check_draw_when_false() {
        //given
        final String[][] testFields = {
                {"X", "X", "O"},
                {"O", "O", "X"},
                {"X", "O", " "}};
        final String testMESSAGE_DRAW = "#           REMIS!            #";
        final boolean expectedDraw = false;
        //when
        boolean actualDraw = AppService.checkDraw(testFields, testMESSAGE_DRAW);
        //then
        assertEquals(expectedDraw, actualDraw);
    }

    @Test
    public void should_check_win_when_true() {
        //given
        final String[][] testFields = {
                {"X", "X", "O"},
                {"O", "O", "X"},
                {"O", "X", " "}};
        final boolean expectedWin = true;
        //when
        boolean actualWin = service.checkWin(testFields);
        //then
        assertEquals(expectedWin, actualWin);
    }

    @Test
    public void should_check_win_when_false() {
        //given
        final String[][] testFields = {
                {"X", "X", " "},
                {"O", "O", "X"},
                {"O", "X", " "}};
        final boolean expectedWin = false;
        //when
        boolean actualWin = service.checkWin(testFields);
        //then
        assertEquals(expectedWin, actualWin);
    }

    @Test
    public void should_show_winner() {
        //given
        final String[][] testFields = {
                {"O", "O", "X"},
                {"O", "X", " "},
                {"X", " ", " "}};
        final String testPlayerOorX = "X";
        final String testMESSAGE_WINNER_1st_HALF = "#          WYGRAŁ ";
        final String testMESSAGE_WINNER_2nd_HALF = " !         #";
        final String expectedMessage =
                "###############################\r\n" +
                        "#     GRA KÓŁKO I KRZYŻYK     #\r\n" +
                        "#          WYGRAŁ X !         #\r\n" +
                        "#                             #\r\n" +
                        "#          O | O | X          #\r\n" +
                        "#          - | - | -          #\r\n" +
                        "#          O | X |            #\r\n" +
                        "#          - | - | -          #\r\n" +
                        "#          X |   |            #\r\n" +
                        "#                             #\r\n" +
                        "###############################\r\n";
        //when
        service.showWinner(testFields, testPlayerOorX, testMESSAGE_WINNER_1st_HALF, testMESSAGE_WINNER_2nd_HALF);
        String actualMessage = outputStream.toString();
        //then
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void should_return_next_player() {
        //given
        final String testPlayerOorX = "X";
        final String expectedPlayer = "O";
        //when
        String actualPlayer = service.nextPlayer(testPlayerOorX);
        //then
        assertEquals(expectedPlayer, actualPlayer);
    }
}