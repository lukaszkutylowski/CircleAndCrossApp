package LukaszKutylowski.CircleAndCross;

import java.util.Scanner;

public class AppService {

    public void showGame(String[][] fields, String MESSAGE_CHOOSE_PLAYER) {
        PrintService.printGame(fields, MESSAGE_CHOOSE_PLAYER);
    }

    public String choosePlayer() {
        int flag = 0;
        String playerOorX = null;

        while(flag == 0) {
            String choose = getScannerInput().toUpperCase();
            if (choose.equals("O")) {
                playerOorX = "O";
                flag = -1;
            } else if (choose.equals("X")) {
                playerOorX = "X";
                flag = -1;
            }
        }
        return playerOorX;
    }

    public void startGame(String[][] fields, String playerOorX, String MESSAGE_PLAYER_1st_HALF, String MESSAGE_PLAYER_2nd_HALF) {
        PrintService.printGame(fields, MESSAGE_PLAYER_1st_HALF + playerOorX + MESSAGE_PLAYER_2nd_HALF);
    }

    public int setCoordinate(boolean row) {
        int coordinate = -1;
        while (coordinate < 0) {
            if (row) {
                PrintService.printMessageRow();
            } else {
                PrintService.printMessageColumn();
            }
            String strCoord = getScannerInput();
            coordinate = Integer.parseInt(strCoord) - 1;
        }
        return coordinate;
    }

    public void setColumnAndRow(String[][] fields, String playerOorX, int row, int column) {
        if (fields[row][column].equals(" ")) {
            fields[row][column] = playerOorX;
        }
    }

    public static boolean checkDraw(String[][] fields, String MESSAGE_DRAW) {
        int emptyFields = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((fields[i][j].equals(" "))) {
                    emptyFields++;
                }
            }
        }
        if (emptyFields == 0) {
            PrintService.printGame(fields, MESSAGE_DRAW);
            return true;
        } else {
            return false;
        }
    }

    public boolean checkWin(String[][] fields) {
        boolean win = false;
        boolean checkWin = checkRowColumnDiagonal(fields);

        if (checkWin) {
            win = true;
        }
        return win;
    }

    private boolean checkRowColumnDiagonal(String[][] fields) {
        boolean win = false;
        boolean[] check = new boolean[8];

        String f11 = fields[0][0], f12 = fields[0][1], f13 = fields[0][2];
        String f21 = fields[1][0], f22 = fields[1][1], f23 = fields[1][2];
        String f31 = fields[2][0], f32 = fields[2][1], f33 = fields[2][2];

        // is Row Win
        check[0] = check3fields(f11, f12, f13);
        check[1] = check3fields(f21, f22, f23);
        check[2] = check3fields(f31, f32, f33);

        // is Column Win
        check[3] = check3fields(f11, f21, f31);
        check[4] = check3fields(f12, f22, f32);
        check[5] = check3fields(f13, f23, f33);

        // is Diagonal Win
        check[6] = check3fields(f11, f22, f33);
        check[7] = check3fields(f13, f22, f31);

        for (int i = 0; i < 8; i++) {
            if (check[i]) {
                win = true;
            }
        }

        return win;
    }

    private boolean check3fields(String one, String two, String three) {
        return (one.equals(two) && two.equals(three)) && (!one.equals(" "));
    }

    public void showWinner(String[][] fields, String playerOorX, String MESSAGE_WINNER_1st_HALF, String MESSAGE_WINNER_2nd_HALF) {
        PrintService.printGame(fields, MESSAGE_WINNER_1st_HALF + playerOorX + MESSAGE_WINNER_2nd_HALF);
    }

    public String nextPlayer(String playerOorX) {
        return playerOorX.equals("X") ? "O" : "X";
    }

    public static String getScannerInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }
}
