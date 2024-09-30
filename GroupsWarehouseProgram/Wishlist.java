import java.util.*; 

public class Wishlist{
    private List<String> wishlist;

    public Wishlist()
    {
        this.wishlist = new ArrayList<>();
    }

    public List<String> getWishlist() {
        return wishlist;
    }
    
    public void addToWishlist(String item){
        wishlist.add(item);
    }

}