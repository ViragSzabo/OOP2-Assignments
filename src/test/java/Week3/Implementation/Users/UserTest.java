package Week3.Implementation.Users;

import Week3.Implementation.Apps.App;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;

public class UserTest extends TestCase {
    User user = new User("Boo", "boo.seventeen@gmail.com", LocalDate.of(1994, 5,2));
    User user2 = new User("Dave", "dave@example.com", LocalDate.of(2007, 8, 8));
    App game = new App("MatureGame", 7.99, true, true);

    public void testGetAge() {
        assertEquals(30, (user.getAge()));
        assertEquals(17, (user2.getAge()));
    }

    public void testCanDownload() {
        assertTrue(user.canDownload(game));
        assertFalse(user2.canDownload(game));
    }

    public void testValidateEmail() {
        assertTrue(User.validateEmail(user.getEmail()));
        assertTrue(User.validateEmail(user2.getEmail()));
    }
}