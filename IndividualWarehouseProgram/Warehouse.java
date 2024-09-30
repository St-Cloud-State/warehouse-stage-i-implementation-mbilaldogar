public class Warehouse {
    private ClientList clients;

    public Warehouse() {
        clients = new ClientList();
    }

    public boolean addClient(String name, String address) {
        Client client = new Client(name, address);
        return clients.addClient(client);
    }

    public void displayClients() {
        clients.displayAllClients();
    }
}