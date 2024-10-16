package Week2.Implementation.UserValidation.Validation;

import Week2.Implementation.UserValidation.User.User;
import Week2.Implementation.UserValidation.ValidationRule;

import java.util.regex.Pattern;

public class EmailValidation implements ValidationRule {
    private static final String EMAIL_PATTERN =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    @Override
    public boolean isValid(User user) throws ValidationException {
        if(!pattern.matcher(user.getEmail()).matches()) {
            throw new ValidationException("Invalid email");
        }
        return true;
    }
}