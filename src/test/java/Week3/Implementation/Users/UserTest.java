package Week3.Implementation.Users;

import junit.framework.TestCase;

import java.time.LocalDate;

public class UserTest extends TestCase {
    User user1 = new User("Alice", "alice@example.com", LocalDate.of(2005, 5, 15));
    User user2 = new User("Bob", "bob@wrong-email", LocalDate.of(2010, 2, 20));
    User user3 = new User("Charlie", "charlie@example.com", LocalDate.of(1985, 10, 5));
    User user4 = new User("Dave", "dave@example.com", LocalDate.of(2007, 8, 8));

    public void testGetAge() {
        assertEquals(19, user1.getAge());
        assertEquals(14, user2.getAge());
        assertEquals(39, user3.getAge());
        assertEquals(17, user4.getAge());
    }
}