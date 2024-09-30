import java.util.Scanner;

public class UserInterface {
    private Warehouse warehouse;
    private Scanner scanner;

    public UserInterface() {
        warehouse = new Warehouse();
        scanner = new Scanner(System.in);
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            displayMenu();
            int choice = getUserChoice();
            switch (choice) {
                case 1:
                    addClient();
                    break;
                case 2:
                    displayAllClients();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n--- Warehouse Management System ---");
        System.out.println("1. Add Client");
        System.out.println("2. Display All Clients");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private int getUserChoice() {
        return Integer.parseInt(scanner.nextLine());
    }

    private void addClient() {
        System.out.print("Enter client's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter client's address: ");
        String address = scanner.nextLine();
        if (warehouse.addClient(name, address)) {
            System.out.println("Client added successfully.");
        } else {
            System.out.println("Error adding client.");
        }
    }

    private void displayAllClients() {
        warehouse.displayClients();
    }

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.run();
    }
}