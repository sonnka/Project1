import java.util.List;
import java.util.Scanner;

public class App {
    private static Users list1 = new Users();
    static
    {
        list1.getUsersList().add(new User(12,"Oleg","Longway",560));
        list1.getUsersList().add(new User(13,"Maria","Reddle",310));
        list1.getUsersList().add(new User(14,"Tom","Pringles",250));
    }
    private static Products list2 = new Products();
    static
    {
        list2.getProductsList().add(new Product(1,"Milk",25));
        list2.getProductsList().add(new Product(2,"Bread",48));
        list2.getProductsList().add(new Product(3,"Cake",300));
    }
    public static void main(String[] args){
        ShowMenu();
        Servers(InputData());
    }
    public static String InputData(){
        Scanner in = new Scanner(System.in);
        String input = in.next();
        return input;
    }
    public static void Servers(String input){
        try{
            int number = Integer.parseInt(input);
            switch(number){
                case 1:
                    list1.ShowUsers();
                    break;
                case 2:
                    list2.ShowProducts();
                    break;
                case 3:
                    System.out.println("Type id of user, who wants to buy a product.");
                    User currentuser = UserSearchById(InputData());
                    System.out.println("Type id of product for buying.");
                    Product currentprod = ProductSearchById(InputData());
                    if(currentuser != null && currentprod != null){
                        Buy(currentuser, currentprod);
                        System.out.println("You buy the product successfully!!! To return to menu type 0.");
                    } else {
                        System.out.println("Try again");
                        ShowMenu();
                    }
                    break;
                case 4:
                    System.out.println("Type id of user to see his/her products.");
                    UserListProd(InputData());
                    break;
                case 5:
                    System.out.println("Type id of product to see users, that bought it.");
                    ProdListUser(InputData());
                    break;
                case 10:
                    System.exit(0);
                default:
                    ShowMenu();
                    break;
            }
            Servers(InputData());
        }
        catch (NumberFormatException ex){
            ShowMenu();
            Servers(InputData());
        }
    }
    private static void ProdListUser(String str) {
        Product pr = ProductSearchById(str);
        if(pr != null && pr.users != null) {
            System.out.println(pr.name + " :");
            for (String tp : pr.users) {
                System.out.println(tp);
            }
        } else{
            System.out.println("Try again");
            ShowMenu();
        }
    }

    private static void UserListProd(String str) {
        User us = UserSearchById(str);
        if(us != null && us.products != null) {
            System.out.println(us.firstname + " " + us.lastname + " :");
            for (String tp : us.products) {
                System.out.println(tp);
            }
        } else{
            System.out.println("Try again");
            ShowMenu();
        }
    }
    private static void Buy(User user, Product prod) {
        if(user.money >= prod.price){
            user.money = user.money - prod.price;
            user.getpr().add(prod.name);
            prod.getus().add(user.firstname + " " + user.lastname);
        } else System.out.println("Not enough money");
    }
    private static Product ProductSearchById(String str) {
        try{
            int num = Integer.parseInt(str);
            switch(num){
                case 1:
                    return list2.getProductsList().get(0);
                case 2:
                    return list2.getProductsList().get(1);
                case 3:
                    return list2.getProductsList().get(2);
                default:
                    System.out.println("Not exist user with such id.");
                    return null;
            }
        }
        catch (NumberFormatException ex){
            return null;
        }
    }
    private static User UserSearchById(String str) {
        try{
            int num = Integer.parseInt(str);
            switch(num){
                case 12:
                    return list1.getUsersList().get(0);
                case 13:
                    return list1.getUsersList().get(1);
                case 14:
                    return list1.getUsersList().get(2);
                default:
                    System.out.println("Don`t exist user with such id.");
                    return null;
            }
        }
        catch (NumberFormatException ex){
            return null;
        }
    }
    public static void ShowMenu(){
        System.out.println("Menu");
        System.out.println("1) List of all users (Type 1) ;");
        System.out.println("2) List of all products (Type 2) ;");
        System.out.println("3) To buy the product (Type 3) ;");
        System.out.println("4) List of user products by user id (Type 4) ;");
        System.out.println("5) List of users that bought product by product id (Type 5) ;");
        System.out.println("6) To return to menu (Type 0) ;");
        System.out.println("To stop the app (Type 10)");
    }
}
