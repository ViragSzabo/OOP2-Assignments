package Week3.Implementation.Users;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;

public class UserTest extends TestCase {
    private User user;

    @Before
    public void setUp() {
        user = new User("Boo", "boo.seventeen@gmail.com", LocalDate.of(1994, 5,2));
    }

    @Test
    public void testTestGetName() {
        assertEquals("Boo", user.getName());
    }

    @Test
    public void testTestSetName() {
        user.setName("BooBear");
        assertEquals("BooBear", user.getName());
    }

    @Test
    public void testGetEmail() {
        assertEquals("boo.seventeen@gmail.com", user.getEmail());
    }

    @Test
    public void testSetEmail() {
        user.setEmail("boo.seventeenN@gmail.com");
        assertEquals("boo.seventeenN@gmail.com", user.getEmail());
    }

    @Test
    public void testGetBirthDate() {
        assertEquals(LocalDate.of(1994, 5,2), user.getBirthDate());
    }

    @Test
    public void testSetBirthDate() {
        user.setBirthDate(LocalDate.of(1994, 5,2));
        assertEquals(LocalDate.of(1994, 5,2), user.getBirthDate());
    }

    @Test
    public void testGetAge() {
        assertEquals(30, (user.getAge()));
    }
}