package Week2.Implementation.UserValidation.User;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

public class UserStorageTest extends TestCase {
    private User user;
    private UserStorage userStorage;

    @Before
    public void setUp() {
        user = new User("Boo", "atteezz20.", "boo.seventeen@gmail.com", new Date(1994, Calendar.MAY,2));
        userStorage = new UserStorage();
    }

    @Test
    public void testGetUsernames() {
        assertEquals(0, userStorage.getUsernames().size());
    }

    @Test
    public void testSetUsernames() {
        HashSet set = new HashSet();
        userStorage.setUsernames(set);
        assertEquals(0, userStorage.getUsernames().size());
    }
    
    @Test
    public void testAddUser() {
        userStorage.addUser(user);
        assertEquals(1, userStorage.getUsernames().size());
    }
}