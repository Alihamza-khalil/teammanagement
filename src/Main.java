import java.util.Scanner;
public class Main {
    static final int max_player = 11;
    static String[] playersName = new String[max_player];
    static String[] playersRole = new String[max_player];
    static int playerCount = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("\n----------Team Management System----------");
        int choice;
        do {
            System.out.println("1) Add player ");
            System.out.println("2) View team ");
            System.out.println("3) Update player name ");
            System.out.println("4) Update player Role ");
            System.out.println("5) Exit");
            System.out.print("Enter your choice: ");
            System.out.print("Enter your tttttt: ");
            choice = in.nextInt();
            in.nextLine();
            switch (choice) {
                case 1:
                    addPlayer(in);
                    break;
                case 2:
                    viewTeam();
                    break;
                case 3:
                    updatePlayer(in);
                    break;
                case 4:
                    updateRole(in);
                    break;
                case 5:
                    System.out.println("Good bye");
                    break;
                default:
                    System.out.println("Enter valid option");

            }

        } while (choice != 5);

    }
    public static void clearScreen() {
        for (int a = 0; a < 50; a++) {
            System.out.println();
        }
    }


    public static void addPlayer(Scanner in) {
        System.out.println("------add player------");
        System.out.print("player name :");
        playersName[playerCount] = in.nextLine();

        System.out.print("Role (batsman,bowler,wicketkeeper,All rounder) :");
        playersRole[playerCount] = in.nextLine();
        playerCount++;

        System.out.println("Player added successfully!");

    }

    public static void viewTeam() {
        System.out.println("------ view team------  ");
        if (playerCount == 0) {
            System.out.println(" No Players in the team yet ");
            return;
        }
        for (int i = 0; i < playerCount; i++) {
            System.out.println( (i + 1) + "." + playersName[i] + " - " + playersRole[i]);
        }


    }

    public static void updatePlayer(Scanner in) {
        System.out.print("Enter the player name you want to update : ");
        String name = in.nextLine();
        if (playerCount == 0) {
            System.out.println("No player added yet ");
            return;
        }
        for (int i = 0; i < playerCount; i++) {
            if (playersName[i].equalsIgnoreCase(name)) {
                System.out.print("Enter new name :");
                playersName[i] = in.nextLine();
                System.out.println("player name update successfully");
                return;
            }
        }
                System.out.println(" player not found ");


    }

    public static void updateRole(Scanner in) {
        System.out.print("Enter the player name you want to update : ");
        String name = in.nextLine();
        if (playerCount == 0) {
            System.out.println("No player added yet ");
            return;
        }
        for (int i = 0; i < playerCount; i++) {
            if (playersName[i].equalsIgnoreCase(name)) {
                System.out.print("Enter Role :");
                playersRole[i] = in.nextLine();
                System.out.println("Role update successfully");
                return;
            }
        }
            System.out.println("Name not found in team ");

    }
}



















