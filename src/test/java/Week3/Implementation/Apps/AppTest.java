package Week3.Implementation.Apps;

import Week3.Implementation.Users.User;
import junit.framework.TestCase;

import java.time.LocalDate;

public class AppTest extends TestCase {
    App app = new App("Puzzle Game", 1.99, false, true);
    User user1 = new User("Alice", "alice@example.com", LocalDate.of(2012, 1, 1));
    User user2 = new User("Bob", "bob@example.com", LocalDate.of(2000, 11, 14));

    public void testTestGetName() {
        assertEquals("Puzzle Game", app.getName());
    }

    public void testTestSetName() {
        app.setName("Puzzle Game 2");
        assertEquals("Puzzle Game 2", app.getName());
    }

    public void testGetPrice() {
        assertEquals(1.99, app.getPrice(), 0);
    }

    public void testSetPrice() {
        app.setPrice(2.99);
        assertEquals(2.99, app.getPrice(), 0);
    }

    public void testIsContainsViolence() {
        assertFalse(app.isContainsViolence());
    }

    public void testSetContainsViolence() {
        app.setContainsViolence(true);
        assertTrue(app.isContainsViolence());
    }

    public void testIsContainsNudity() {
        assertTrue(app.isContainsNudity());
    }

    public void testSetContainsNudity() {
        app.setContainsNudity(false);
        assertFalse(app.isContainsNudity());
    }

    public void testValidateAge() {
        assertFalse(app.validateAge(user1.getAge()));
        assertTrue(app.validateAge(user2.getAge()));
    }
}