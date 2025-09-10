import java.util.Scanner;

public class Main {
    static String[] playerId = new String[max_player];
    static final int MAX_PLAYERS = 11;
    static String[] playersName = new String[MAX_PLAYERS];
    static String[] playersRole = new String[MAX_PLAYERS];
    static String[] playerId = new String[MAX_PLAYERS];
    static int playerCount = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\n---------- Team Management System ----------");
            System.out.println("1) Add player");
            System.out.println("2) View team");
            System.out.println("3) Update name");
            System.out.println("4) Update role");
            System.out.println("5) Remove player");
            System.out.println("6) Exit");

            while (true) {
                System.out.print("Enter your choice: ");
                String input = in.nextLine();
                if (input.matches("\\d+")) {
                    choice = Integer.parseInt(input);
                    break;
                } else {
                    System.out.println("Choice must be a number!");
                }
            }

            switch (choice) {
                case 1 -> addPlayer(in);
                case 2 -> viewTeam();
                case 3 -> updatePlayerName(in);
                case 4 -> updateRole(in);
                case 5 -> removePlayer(in);
                case 6 -> System.out.println("Goodbye!");
                default -> System.out.println("Enter a valid option (1–6).");
            }

        } while (choice != 6);
    }

    // Add a player
    public static void addPlayer(Scanner in) {
        if (playerCount >= MAX_PLAYERS) {
            System.out.println("Team is full! Cannot add more than " + MAX_PLAYERS + " players.");
            return;
        }

        System.out.println("------ Add Player ------");

        String id;
        while (true) {
            System.out.print("Enter player ID: ");
            id = in.nextLine().trim();
            boolean exists = false;
            for (int i = 0; i < playerCount; i++) {
                if (playerId[i].equals(id)) {
                    System.out.println("Duplicate ID not allowed.");
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                playerId[playerCount] = id;
                break;
            }
        }

        String name;
        while (true) {
            System.out.print("Enter player name: ");
            name = in.nextLine().trim();
            if (name.matches("^[A-Za-z ]+$")) {
                playersName[playerCount] = name;
                break;
            } else {
                System.out.println("Name must contain only letters and spaces.");
            }
        }

        while (true) {
            System.out.print("Enter role (1.Batsman, 2.Bowler, 3.Wicketkeeper, 4.All Rounder): ");
            String input = in.nextLine();
            if (input.matches("\\d")) {
                int option = Integer.parseInt(input);
                switch (option) {
                    case 1 -> playersRole[playerCount] = "Batsman";
                    case 2 -> playersRole[playerCount] = "Bowler";
                    case 3 -> playersRole[playerCount] = "Wicketkeeper";
                    case 4 -> playersRole[playerCount] = "All Rounder";
                    default -> {
                        System.out.println("Invalid choice! Enter 1–4.");
                        continue;
                    }
                }
                break;
            } else {
                System.out.println("Choice must be a number!");
            }
        }

        playerCount++;
        System.out.println("Player added successfully!");
    }

    // View team
    public static void viewTeam() {
        System.out.println("------ View Team ------");
        if (playerCount == 0) {
            System.out.println("No players in the team yet.");
            return;
        }
        for (int i = 0; i < playerCount; i++) {
            System.out.println(playerId[i] + ". " + playersName[i] + " - " + playersRole[i]);
        }
    }

    // Update player name
    public static void updatePlayerName(Scanner in) {
        if (playerCount == 0) {
            System.out.println("No player added yet.");
            return;
        }

        int index = findPlayerById(in, "Enter ID of the player to update name: ");
        System.out.print("Enter new name: ");
        String newName = in.nextLine().trim();
        playersName[index] = newName;
        System.out.println("Player name updated successfully!");
    }

    // Update role
    public static void updateRole(Scanner in) {
        if (playerCount == 0) {
            System.out.println("No player added yet.");
            return;
        }

        int index = findPlayerById(in, "Enter ID of the player to update role: ");

        while (true) {
            System.out.print("Enter new role (1.Batsman, 2.Bowler, 3.Wicketkeeper, 4.All Rounder): ");
            String input = in.nextLine();
            if (input.matches("\\d")) {
                int option = Integer.parseInt(input);
                switch (option) {
                    case 1 -> playersRole[index] = "Batsman";
                    case 2 -> playersRole[index] = "Bowler";
                    case 3 -> playersRole[index] = "Wicketkeeper";
                    case 4 -> playersRole[index] = "All Rounder";
                    default -> {
                        System.out.println("Invalid choice! Enter 1–4.");
                        continue;
                    }
                }
                System.out.println("Role updated successfully!");
                break;
            } else {
                System.out.println("Choice must be a number!");
            }
        }
    }

    // Remove a player
    public static void removePlayer(Scanner in) {
        if (playerCount == 0) {
            System.out.println("No player added yet.");
            return;
        }

        int index = findPlayerById(in, "Enter ID of the player to remove: ");

        for (int i = index; i < playerCount - 1; i++) {
            playerId[i] = playerId[i + 1];
            playersName[i] = playersName[i + 1];
            playersRole[i] = playersRole[i + 1];
        }
        playerCount--;

        System.out.println("Player removed successfully!");
    }

    // Helper method: find player index by ID
    private static int findPlayerById(Scanner in, String prompt) {
        int found = -1;
        while (true) {
            System.out.print(prompt);
            String id = in.nextLine().trim();
            for (int i = 0; i < playerCount; i++) {
                if (playerId[i].equals(id)) {
                    found = i;
                    break;
                }
            }
            if (found != -1) {
                return found;
            } else {
                System.out.println("This ID is not registered yet.");
            }
        }
    }
}
