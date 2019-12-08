import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class UserService {
    private static List<User> users = new ArrayList<>();

    static public int usersAmount(){
        return users.size();
    }

    static public void addUser(User user){users.add(user);}

    static public User[] getAllUsers(){
            User[] usersArr = new User[users.size()];
            usersArr = users.toArray(usersArr);
            return usersArr;
    }

    static public User getUser(int user_id){
        for (User usr : users){
            if (usr.getId()==user_id)
                return usr;
        }
        return null;
    }

    static public User deleteUser(int user_id){
        User userToReturn;
        for (User usr : users){
            if (usr.getId()==user_id) {
                userToReturn = usr;
                users.remove(usr);
                return userToReturn;
            }
        }
        return null;
    }

    static public User updateUser(int id, User user_to_update){
        for (User usr : users){
            if (usr.getId()==id) {
                usr.setFirstname(user_to_update.getFirstname());
                usr.setLastname(user_to_update.getLastname());
                return usr;
            }
        }
        return null;
    }
}
