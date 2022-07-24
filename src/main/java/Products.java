import java.util.ArrayList;
import java.util.List;

public class Products {
    public List<Product> productslist;
    public List<Product> getProductsList() {
        if(productslist == null) {
            productslist = new ArrayList<>();
        }
        return productslist;
    }
   public void ShowProducts(){
       for (Product prod:productslist) {
           System.out.println(prod.toString());
       }
   }

}
