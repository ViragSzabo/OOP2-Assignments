package Week2.Implementation.UserValidation.User;

import java.util.HashSet;

public class UserStorage {
    private final HashSet<String> usernames = new HashSet<>();
    public void addUser(User user) {
        if(usernames.contains(user.getName())) {
            throw new IllegalArgumentException("Username already exists");
        }
        usernames.add(user.getName());
    }
}