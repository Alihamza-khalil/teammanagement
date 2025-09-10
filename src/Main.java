import java.util.Scanner;
public class Main {
    static final int max_player = 11;
    static String[] playersName = new String[max_player];
    static String[] playersRole = new String[max_player];
    static String[] playerId = new String[max_player];
    static int playerCount = 0;
    static String id;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\n----------Team Management System----------");
            System.out.println("1) Add player ");
            System.out.println("2) View team ");
            System.out.println("3) Update name ");
            System.out.println("4) Update Role ");
            System.out.println("5) Remove player");
            System.out.println("6) Exit  ");

            while (true) {
                System.out.print("Enter your Choice: ");
                String input = in.nextLine();

                if (input.matches("\\d+")) {
                    choice = Integer.parseInt(input);
                    break;
                } else {
                    System.out.println("Choice! Must be a number ");
                }
            }
            switch (choice) {
                case 1:
                    addPlayer(in);
                    break;
                case 2:
                    viewTeam();
                    break;
                case 3:
                    updatePlayerName(in);
                    break;
                case 4:
                    updateRole(in);
                    break;
                case 5:
                    removePlayer(in);
                    break;
                case 6:
                    System.out.println("Good bye ");
                    break;
                default:
                    System.out.println("Enter valid option(1 to 5)");
            }

        } while (choice != 6);

    }

    public static void addPlayer(Scanner in) {
        System.out.println("------add player------");

        while (true) {
            System.out.print("Enter player id :");
            id = in.nextLine();
            boolean found = false;
            for (int i = 0; i < playerCount; i++) {
                if (playerId[i].equals(id)) {
                    System.out.println("You cannot use duplicate id ");
                    found = true;
                    break;
                }
            }
            if (!found) {
                playerId[playerCount] = id;
                break;
            }
        }
        String name;
        while (true) {
            System.out.print("Enter player name : ");
            name = in.nextLine();
            if (name.matches("^[A-Za-z ]+$")) {
                break;
            } else {
                System.out.println(" Names contain only letters ");
            }
        }
        playersName[playerCount] = name;
        int option;
        while (true) {
            System.out.print("Enter the Role (1.Batsman , 2.Bowler , 3.Wicketkeeper , 4.All Rounder)  :");
            String input = in.nextLine();

            if (input.matches("\\d")) {
                option = Integer.parseInt(input);

                if (option >= 1 && option <= 4) {
                    switch (option) {
                        case 1:
                            playersRole[playerCount] = "Batsman";
                            break;
                        case 2:
                            playersRole[playerCount] = "Bowler";
                            break;
                        case 3:
                            playersRole[playerCount] = "Wicketkeeper";
                            break;
                        case 4:
                            playersRole[playerCount] = "All Rounder";
                            break;
                    }
                    break;
                } else {
                    System.out.println("Invalid choice! Enter 1–4.");
                }
            } else {
                System.out.println("Choice must be a number!");
            }
        }

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
            System.out.println(playerId[i] + "." + playersName[i] + " - " + playersRole[i]);
        }
    }

    public static void updatePlayerName(Scanner in) {
        if (playerCount == 0) {
            System.out.println("No player added yet ");
            return;
        }
        int found = -1;
        while (true) {
            System.out.print("Enter ID of the player to update his name : ");
            id = in.nextLine();

            for (int i = 0; i < playerCount; i++) {
                if (playerId[i].equals(id)) {
                    found = i;
                    break;
                }
            }
            if (found != -1) {
                break;
            } else {
                System.out.println(" This ID is not registered yet ");
            }
        }

        System.out.print("Enter new name :");
        playersName[found] = in.nextLine();
        System.out.println("Player name updated successfully");
    }

    public static void updateRole(Scanner in) {
        if (playerCount == 0) {
            System.out.println("No player added yet ");
            return;
        }
        int found = -1;
        while (true) {
            System.out.print("Enter ID of the player to update his role : ");
            id = in.nextLine();
            for (int i = 0; i < playerCount; i++) {
                if (playerId[i].equals(id)) {
                    found = i;
                    break;
                }
            }
            if (found != -1) {
                break;
            } else {
                System.out.println("This ID is not registered yet");
            }
        }

        int option;
        while (true) {
            System.out.println("Enter new Role (1.Batsman , 2.Bowler , 3.Wicketkeeper , 4.All Rounder)  :");
            String input = in.nextLine();

            if (input.matches("\\d+")) {
                option = Integer.parseInt(input);
                if (option >= 1 && option <= 4) {
                    int var;
                    switch (option) {
                        case 1:
                            playersRole[found] = "Batsman";
                            break;
                        case 2:
                            playersRole[found] = "Bowler";
                            break;
                        case 3:
                            playersRole[found] = "Wicketkeeper";
                            break;
                        case 4:
                            playersRole[found] = "All Rounder";
                            break;
                    }
                    System.out.println("Role updated successfully");
                    break;
                } else {
                    System.out.println("Invalid choice! Enter 1–4.");
                }

            } else {
                System.out.println("Option must be a digit");
            }
        }
    }

    public static void removePlayer(Scanner in) {
        if (playerCount == 0) {
            System.out.println("No player added yet");
            return;
        }

        int removeIndex = -1;

        while (true) {
            System.out.print("Enter ID to remove: ");
            id = in.nextLine();

            for (int i = 0; i < playerCount; i++) {
                if (playerId[i].equals(id)) {
                    removeIndex = i;
                    break; // found the player
                }
            }

            if (removeIndex == -1) {
                System.out.println("ID not found. Try again.");
            } else {
                break;
            }
        }

        for (int i = removeIndex; i < playerCount ; i++) {
            playerId[i] = playerId[i + 1];
            playersName[i] = playersName[i + 1];
            playersRole[i] = playersRole[i + 1];
        }
        playerCount--;

        System.out.println("Player with ID " + id + " removed successfully!");
    }

}