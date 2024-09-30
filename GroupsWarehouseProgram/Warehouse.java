public class Warehouse {
    ClientList newClientList = new ClientList();
    ProductList newProductList = new ProductList();
    OrderList newOrderList = new OrderList();

    // Add a new client to the warehouse
    public boolean addClient(String name, String address) {
        Client newClient = new Client(name, address);
        return newClientList.addClient(newClient);
    }

    // Add a new product to the warehouse
    public boolean addProduct(String name, int quantity, double price) {
        Product newProduct = new Product(name, quantity, price);
        return newProductList.addProduct(newProduct);
    }

    public boolean addItemToWishlist(String clientID, String productID)
    {
        Client client = getClientById(clientID);
        if(client != null)
        {
            Product product = newProductList.searchProductById(productID);
            if(product != null)
            {
                client.addtowishlist(product.getName());
                return true;
            }
        }
        return false;
    }

    // Add a new Order to the warehouse
    public boolean addOrder(String clientId, String productId, int quantity) {
        Order newOrder = new Order(clientId, productId, quantity);
        return newOrderList.addOrder(newOrder);
    }

    // Display all clients in the warehouse
    public void displayClients() {
        if (newClientList.isEmpty()) {
            System.out.println("No clients found.");
        } else {
            newClientList.displayAllClients();
        }
    }

    public boolean search(String ID)
    {
        if (newClientList.getClient(ID) != null)
        {
            System.out.println("You are in the system");
            return true;
        }
        return false;
    }

    public boolean searchproduct(String Pro_Id){
            
        if (newProductList.searchProductById(Pro_Id) != null)
        {
            return true;
        }
        return false;
    }

    // Display all products in the warehouse
    public void displayProducts() {
        if (newProductList.isEmpty()) {
            System.out.println("No products found.");
        } else {
            newProductList.displayAllProducts();
        }
    }

    public Client getClientById(String clientId) {

        return newClientList.getClient(clientId);
        }

        public void displayWishlist(String clientId) {
            Client client = getClientById(clientId);
            if (client != null) {
                System.out.println("Wishlist for client " + client.getName() + ": " + client.getWishlist().getWishlist());
            } else {
                System.out.println("Client not found.");
            }
    }

    // Display orders by customer Id in the warehouse
    public void displayOrders(String clientId) {
        if (newOrderList.isEmpty()) {
            System.out.println("No orders found.");
        } else {
            //newOrderList.displayAllOrders();
            newOrderList.displayOrders(clientId);
        }
    }
}
