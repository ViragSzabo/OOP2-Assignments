package Week3.Implementation.Apps;

import Week3.Implementation.Users.User;
import junit.framework.TestCase;

import java.time.LocalDate;

public class AppTest extends TestCase {
    App game1 = new App("ActionGame", 5.99, true, false);
    App game2 = new App("ArtApp", 3.49, false, true);
    App game3 = new App("CasualGame", 1.99, false, false);
    App game4 = new App("MatureGame", 7.99, true, true);

    User user1 = new User("Alice", "alice@example.com", LocalDate.of(2005, 5, 15));
    User user2 = new User("Bob", "bob@wrong-email", LocalDate.of(2010, 2, 20));
    User user3 = new User("Charlie", "charlie@example.com", LocalDate.of(1985, 10, 5));
    User user4 = new User("Dave", "dave@example.com", LocalDate.of(2007, 8, 8));
    User user5 = new User("Dave", "dave@example.com", LocalDate.of(2013, 8, 8));

    public void testValidateAge() {
        assertTrue(game1.validateAge(user1.getAge()));
        assertTrue(game3.validateAge(user3.getAge()));

        assertFalse(game2.validateAge(user2.getAge()));
        assertFalse(game4.validateAge(user4.getAge()));
        assertFalse(game4.validateAge(user5.getAge()));
    }
}