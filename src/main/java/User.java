import java.util.ArrayList;
import java.util.List;

public class User {
    public Integer id;
    public String firstname;
    public String lastname;
    public Integer money;
    public List<String> products;
    public List<String> getpr() {
        if(products == null) {
            products = new ArrayList<>();
        }
        return products;
    }
    public User(){
    }
    public User(Integer id,String firstname, String lastname, Integer money){
        super();
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.money = money;
    }
    @Override
    public String toString(){
        return "User " + id + ":  " + firstname + " " + lastname + " || Amount of money: " + money;
    }
}
