package Week2.Implementation.UserValidation;

import Week2.Implementation.UserValidation.User.User;
import Week2.Implementation.UserValidation.User.UserStorage;
import Week2.Implementation.UserValidation.User.UserValidator;
import Week2.Implementation.UserValidation.Validation.AgeValidation;
import Week2.Implementation.UserValidation.Validation.EmailValidation;
import Week2.Implementation.UserValidation.Validation.PasswordValidation;
import Week2.Implementation.UserValidation.Validation.ValidationException;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Example {
    public static void main(String[] args) {
        try {
            List<ValidationRule> rules = new ArrayList<>();
            rules.add(new PasswordValidation(false, true, true, true, true));
            rules.add(new AgeValidation(18));
            rules.add(new EmailValidation());

            UserStorage storage = new UserStorage();
            UserValidator validator = new UserValidator(storage);
            User user = new User("nick-ul", "Circle123*", "nick.texas@gmail.com", new Date(97, 9, 14));

            validator.validate(user);
            System.out.println("User is validated!");
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
    }
}