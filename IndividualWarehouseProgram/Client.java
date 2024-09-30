import java.io.Serializable;

public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String address;
    private String id;

    public Client(String name, String address) {
        this.name = name;
        this.address = address;
        this.id = ClientIdServer.instance().getId(); 
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Client) {
            Client other = (Client) obj;
            return this.id.equals(other.id);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Client [ID: " + id + ", Name: " + name + ", Address: " + address + "]";
    }
}