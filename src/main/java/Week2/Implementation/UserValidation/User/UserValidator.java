package Week2.Implementation.UserValidation.User;

import Week2.Implementation.UserValidation.ValidationRule;
import Week2.Implementation.UserValidation.Validation.ValidationException;

import java.util.List;

public class UserValidator {
    private final List<ValidationRule> validationRuleList;
    private final UserStorage userStorage;

    public UserValidator(List<ValidationRule> validationRuleList, UserStorage userStorage) {
        this.validationRuleList = validationRuleList;
        this.userStorage = userStorage;
    }

    public boolean validate(User user) throws ValidationException {
        for (ValidationRule validationRule : validationRuleList) {
            validationRule.isValid(user);
        }
        userStorage.addUser(user);
        return true;
    }
}