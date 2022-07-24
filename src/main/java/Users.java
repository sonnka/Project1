import java.util.ArrayList;
import java.util.List;

public class Users {
    public List<User> userlist;
    public List<User> getUsersList() {
        if(userlist == null) {
            userlist = new ArrayList<>();
        }
        return userlist;
    }
     public void ShowUsers(){
         for (User us:userlist) {
             System.out.println(us.toString());
         }
     }

}
