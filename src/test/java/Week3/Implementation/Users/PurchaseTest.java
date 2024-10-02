package Week3.Implementation.Users;

import Week3.Implementation.Apps.App;
import junit.framework.TestCase;

import java.time.LocalDate;

public class PurchaseTest extends TestCase {
    private User user;
    private Purchase purchase;
    private App app;

    public void setUp() {
        user = new User("Boo", "boo.seventeen@gmail.com", LocalDate.of(1994, 5,2));
        app = new App("Super Fighter", 5.99, true, false);
        purchase = new Purchase(user, app);
    }

    public void testGetApp() {
        assertEquals(app, purchase.getApp());
    }

    public void testSetApp() {
        App newApp = new App("Romance Story", 3.99, false, true);
        purchase.setApp(newApp);
        assertEquals(newApp, purchase.getApp());
    }

    public void testGetUser() {
        assertEquals(user, purchase.getUser());
    }

    public void testSetUser() {
        User newUser = new User("Bob", "bob@example.com", LocalDate.of(2000, 11, 14));
        purchase.setUser(newUser);
        assertEquals(newUser, purchase.getUser());
    }
}