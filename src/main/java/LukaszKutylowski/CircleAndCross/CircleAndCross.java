package LukaszKutylowski.CircleAndCross;

public class CircleAndCross {
    public static void main(String[] args) {
        AppService service = new AppService();
        String[][] fields = {
                {" ", " ", " "},
                {" ", " ", " "},
                {" ", " ", " "}};
        String MESSAGE_CHOOSE_PLAYER = "# Pierwszy gracz: O czy X ?   #";
        String MESSAGE_PLAYER_1st_HALF = "# Gracz: ";
        String MESSAGE_PLAYER_2nd_HALF = "                    #";
        String MESSAGE_WINNER_1st_HALF = "#          WYGRAŁ ";
        String MESSAGE_WINNER_2nd_HALF = " !         #";
        String MESSAGE_DRAW = "#           REMIS!            #";

        service.showGame(fields, MESSAGE_CHOOSE_PLAYER);
        String playerOorX = service.choosePlayer();

        int flag = 0;
        while(flag == 0) {
            service.startGame(fields, playerOorX, MESSAGE_PLAYER_1st_HALF, MESSAGE_PLAYER_2nd_HALF);
            int row = service.setCoordinate(true);
            int column = service.setCoordinate(false);
            service.setColumnAndRow(fields, playerOorX, row, column);

            boolean draw = AppService.checkDraw(fields, MESSAGE_DRAW);
            if (draw) {
                flag = -1;
            }

            boolean win = service.checkWin(fields);
            if (win) {
                service.showWinner(fields, playerOorX, MESSAGE_WINNER_1st_HALF, MESSAGE_WINNER_2nd_HALF);
                flag = -1;
            }

            playerOorX = service.nextPlayer(playerOorX);
        }
    }
}
