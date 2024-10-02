package Week2.Implementation.UserValidation.User;

import Week2.Implementation.UserValidation.Validation.ValidationException;
import Week2.Implementation.UserValidation.ValidationRule;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class UserValidatorTest extends TestCase {
    private User user;
    private UserStorage userStorage;
    private UserValidator validator;
    private ValidationRule validationRule;

    @Before
    public void setUp() {
        user = new User("Boo", "atteezz20.", "boo.seventeen@gmail.com", new Date(1994, Calendar.MAY,2));
        userStorage = new UserStorage();
        validator = new UserValidator(userStorage);
        validationRule = new ValidationRule() {
            @Override
            public boolean isValid(User user) throws ValidationException {
                return true;
            }
        };
    }

    @Test
    public void testGetValidationRuleList() {
        assertEquals(0, validator.getValidationRuleList().size());

    }

    @Test
    public void testGetUserStorage() {
        assertEquals(userStorage, validator.getUserStorage());
    }

    @Test
    public void testValidate() {
        try {
            assertTrue(validator.validate(user));
        } catch (ValidationException e) {
            throw new RuntimeException(e);
        }
    }
}