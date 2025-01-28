import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*
          Feladat: készíts 4 alapműveletes számológépet, menüvel
        */
        Scanner io = new Scanner(System.in);
        outLine("Számológép program");
        int menuItem;
        menuItem = displayMenu(io);
        outLine("A válaszod: " + menuItem);
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