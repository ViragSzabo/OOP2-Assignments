package Week2.Implementation.UserValidation.User;

import java.util.HashSet;

public class UserStorage {
    private HashSet<String> usernames = new HashSet<>();

    public UserStorage() {
        usernames = new HashSet<>();
    }

    public HashSet<String> getUsernames() {
        return usernames;
    }

    public void setUsernames(HashSet<String> usernames) {
        this.usernames = usernames;
    }

    public void addUser(User user) {
        if(usernames.contains(user.getName())) {
            throw new IllegalArgumentException("Username already exists");
        }
        usernames.add(user.getName());
    }
}