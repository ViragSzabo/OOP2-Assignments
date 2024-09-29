package Week3.Implementation.Users;

public class EmailValidator {
    public static String validateEmail(String email) {
        if (email != null && email.contains("@") && email.contains(".")) {
            return email;
        }
        return null;
    }
}