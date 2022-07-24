import java.util.ArrayList;
import java.util.List;

public class Product {
    public Integer id;
    public String name;
    public Integer price;
    public List<String> users ;
    public List<String> getus() {
        if(users == null) {
            users = new ArrayList<>();
        }
        return users;
    }

    public Product() {
    }

    public Product( Integer id, String name, Integer price){
        super();
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString(){
        return "Product " + id + " : " + name + " - " + price;
    }
}
