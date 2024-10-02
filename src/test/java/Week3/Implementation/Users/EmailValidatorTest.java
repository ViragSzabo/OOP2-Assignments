package Week3.Implementation.Users;

import junit.framework.TestCase;

import java.time.LocalDate;

public class EmailValidatorTest extends TestCase {
    private EmailValidator emailValidator;
    private User user;
    private User noEmailUser;

    public void setUp() {
        user = new User("Boo", "boo.seventeen@gmail.com", LocalDate.of(1994, 5,2));
        noEmailUser = new User("Moo", "", LocalDate.of(1995, 12,22));
        emailValidator = new EmailValidator();
    }

    public void testValidateEmail() {
        assertEquals("boo.seventeen@gmail.com", EmailValidator.validateEmail(user.getEmail()));
        assertNull(EmailValidator.validateEmail(noEmailUser.getEmail()));
    }
}