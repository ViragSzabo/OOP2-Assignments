package Week2.Implementation.UserValidation;

import Week2.Implementation.UserValidation.User.User;
import Week2.Implementation.UserValidation.Validation.ValidationException;

public interface ValidationRule {
    boolean isValid(User user) throws ValidationException;
}