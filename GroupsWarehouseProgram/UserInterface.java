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
                    addProduct();
                    break;
                case 3:
                    addwishlist();
                    break;
                case 4:
                    addOrder();
                    break;
                case 5:
                    displayAllClients();
                    break;
                case 6:
                    displayAllProducts();
                    break;
                case 7:
                    displayWlist();
                    break;
                case 8:
                    displayOrderById();
                    break;
                case 9:
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
        System.out.println("2. Add Product");
        System.out.println("3. Add Product to Client's Wishlist");
        System.out.println("4. Add Product to Client's Order");
        System.out.println("5. Display All Clients");
        System.out.println("6. Display All Products");
        System.out.println("7. Display Client's Wishlist");
        System.out.println("8. Display Order By Client ID");
        System.out.println("9. Exit");
        System.out.print("Enter your choice: ");
    }

    private int getUserChoice() {
        return Integer.parseInt(scanner.nextLine());
    }

    // Adding a new client to the warehouse
    private void addClient() {
        System.out.print("Enter client's name: ");
        String var1 = this.scanner.nextLine();
        System.out.print("Enter client's address: ");
        String var2 = this.scanner.nextLine();
        if (this.warehouse.addClient(var1, var2)) {
           System.out.println("Client added successfully.");
        } else {
           System.out.println("Error adding client.");
        }
  
     }

    // Adding a new product to the warehouse
    private void addProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter product sale price: ");
        double price = Double.parseDouble(scanner.nextLine());
        if (warehouse.addProduct(name, quantity, price)) {
            System.out.println("Product added successfully.");
        } else {
            System.out.println("Error adding product.");
        }
    }

    // Adding a new product to the order from the warehouse
    private void addOrder(){
        String clientId;
        String productId;
        int quantity;

        // Checking that client ID is valid
        do {
            System.out.print("Enter Client's ID: ");
            clientId = this.scanner.nextLine();

            if (warehouse.newClientList.getClient(clientId) == null) {
                System.out.println("Invalid Client ID. Please try again.");
            }
        } while (warehouse.newClientList.getClient(clientId) == null);

        // Checking that product ID is valid
        do {
            System.out.print("Enter Products's ID: ");
            productId = this.scanner.nextLine();

            if (warehouse.newProductList.searchProductById(productId) == null) {
                System.out.println("Invalid Product ID. Please try again.");
            }
        } while (warehouse.newProductList.searchProductById(productId) == null);

        // Checking that quantity avalible is valid
        int avalibleQuantity = warehouse.newProductList.getQtyById(productId);
        do {
            System.out.print("Enter product quantity: ");
            quantity = Integer.parseInt(scanner.nextLine());

            if (quantity > avalibleQuantity) {
                System.out.println("Sorry we only have " + avalibleQuantity + " in stock. Please enter a valid quantity.");
            }
        } while (quantity > avalibleQuantity);

        // Changing the value of the quanity of the list
        int newQuantity = avalibleQuantity - quantity;
        warehouse.newProductList.setQtyById(productId, newQuantity);

        if (warehouse.addOrder(clientId, productId, quantity)) {
            System.out.println("Order added successfully.");
        } else {
            System.out.println("Error adding Order.");
        }
    }

    private void addwishlist(){

        String user_option = "y";
        System.out.print("Enter Client's ID: ");
        String User_id = scanner.nextLine();
        if(warehouse.search(User_id))
        {
            while (user_option.equals("y")) {
                System.out.println("Enter Product's ID");
                String products_id = scanner.nextLine();
                if(warehouse.searchproduct(products_id))
                {
                    warehouse.addItemToWishlist(User_id, products_id);
                }
                else
                {
                    System.out.println("prodcut does not exist");
                }
                System.out.println("want to keep going? y/n");
                user_option = scanner.nextLine();
        }
        }
        else
        {
            System.out.println("You are not in. Please add yourself");
        }
        
    }

    private void displayWlist()
    {
        System.out.println("Enter Client's ID: ");
        String IDs = scanner.nextLine();
        warehouse.displayWishlist(IDs);
    }

    // Display all clients in the warehouse
    private void displayAllClients() {
        warehouse.displayClients();
    }

    // Display all products in the warehouse
    private void displayAllProducts() {
        warehouse.displayProducts();
    }

     // Display order by customer Id from the warehouse
    private void displayOrderById(){
        String clientId;
        do {
            System.out.print("Enter Client's ID: ");
            clientId = this.scanner.nextLine();

            if (warehouse.newClientList.getClient(clientId) == null) {
                System.out.println("Invalid Client ID. Please try again.");
            }
        } while (warehouse.newClientList.getClient(clientId) == null);

         warehouse.displayOrders(clientId);
    }

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.run();
    }
}