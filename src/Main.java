import java.util.Scanner;

public class Main {

    public static Scanner io = new Scanner(System.in);

    public static void main(String[] args) {
        /*
          Feladat: készíts 4 alapműveletes számológépet, menüvel
        */
        outLine("Számológép program");
        int menuItem = displayMenu(io);
        //outLine("A válaszod: " + menuItem);
        switch (menuItem) {
            case 1:
                addition();
                break;
            case 2:
                subtraction();
                break;
            case 3:
                multiplication();
                break;
            case 4:
                outLine("Osztás");
                break;
        }
        outLine("Köszönöm, hogy kipróbáltad!");
    }

    // konstansok, a bevitelhez
    public static final float MINIMUM = -2000000;
    public static final float MAXIMUM = 2000000;
    public static final String NUMBER1LABEL = "Kérem az első számot (-2000000 - 2000000): ";
    public static final String NUMBER2LABEL = "Kérem a második számot (-2000000 - 2000000): ";

    public static void addition() {
        outLine("Összeadás");
        float number1 = input(NUMBER1LABEL, MINIMUM, MAXIMUM, io);
        float number2 = input(NUMBER2LABEL, MINIMUM, MAXIMUM, io);
        float result = number1 + number2;
        outLine("A két szám összege: " + result);
    }

    public static void subtraction() {
        outLine("Kivonás");
        float number1 = input(NUMBER1LABEL, MINIMUM, MAXIMUM, io);
        float number2 = input(NUMBER2LABEL, MINIMUM, MAXIMUM, io);
        float result = number1 - number2;
        outLine("A két szám különbsége: " + result);
    }

    public static void multiplication() {
        outLine("Szorzás");
        float number1 = input(NUMBER1LABEL, MINIMUM, MAXIMUM, io);
        float number2 = input(NUMBER2LABEL, MINIMUM, MAXIMUM, io);
        double result = number1 * number2; // azért, hogy a számtartományból biztosan ne lépjen ki
        outLine("A két szám szorzata: " + result);
    }

    public static float input(String message, float minimum, float maximum, Scanner io) {
        // megjeleníti a megadott szöveget és addig kér információt, amíg a szám a megadott tartományba nem esik
        String dataLine;
        float answer = minimum - 1;
        do {
            out(message);
            dataLine = io.nextLine();
            try {
                answer = Float.parseFloat(dataLine);
                if (answer < minimum || answer > maximum) {
                    outLine("Kérlek a megadott tartományban adj meg számot!");
                    outLine("------------------------------------");
                }
            } catch (Exception e) {
                outLine("Kérlek számjegyekkel add meg az értéket!");
                outLine("------------------------------------");
            }
        } while (answer < minimum || answer > maximum); // bennmaradási feltétel kell
        return answer;
    }

    public static int displayMenu(Scanner io) {
        String dataLine;
        int answer = -1;
        do {
            outLine("Válassz az alábbi lehetőségek közül:");
            outLine(" 1 - összeadás");
            outLine(" 2 - kivonás");
            outLine(" 3 - szorzás");
            outLine(" 4 - osztás");
            outLine(" 0 - kilépés");
            out("Válaszod: ");
            dataLine = io.nextLine();
            try {
                answer = Integer.parseInt(dataLine);
                if (answer < 0 || answer > 4) {
                    outLine("Kérlek a menü lehetőségei (0-4) közül válassz!");
                    outLine("------------------------------------");
                    answer = -1;
                }
            } catch (Exception e) {
                outLine("Kérlek a válaszod számjegyekkel (egész számként) add meg!");
                outLine("------------------------------------");
            }
        } while (answer == -1); // bennmaradási feltétel kell
        return answer;
    }

    public static void outLine(String message) {
        System.out.println(message);
    }

    public static void out(String message) {
        System.out.print(message);
    }
}
