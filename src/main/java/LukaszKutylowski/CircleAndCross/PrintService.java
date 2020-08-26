package LukaszKutylowski.CircleAndCross;

public class PrintService {

    public static void printGame(String[][] fields, String message) {
        System.out.println("###############################");
        System.out.println("#     GRA KÓŁKO I KRZYŻYK     #");
        System.out.println(message);
        System.out.println("#                             #");
        System.out.println("#          " + fields[0][0] + " | " + fields[0][1] + " | " + fields[0][2] + "          #");
        System.out.println("#          - | - | -          #");
        System.out.println("#          " + fields[1][0] + " | " + fields[1][1] + " | " + fields[1][2] + "          #");
        System.out.println("#          - | - | -          #");
        System.out.println("#          " + fields[2][0] + " | " + fields[2][1] + " | " + fields[2][2] + "          #");
        System.out.println("#                             #");
        System.out.println("###############################");
    }

    public static void printMessageColumn() {
        System.out.print("  Wprowadż numer kolumny: ");
    }

    public static void printMessageRow() {
        System.out.print("  Wprowadż numer wiersza: ");
    }
}
