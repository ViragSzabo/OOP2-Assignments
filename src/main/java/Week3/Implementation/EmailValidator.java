package Week3.Implementation;

public class EmailValidator {
    public static String validateEmail(String email) {
        if (email.contains("@")) {
            return email;
        }
        return null;
    }
}