package Week3.Implementation.Apps;

import Week3.Implementation.Conditions.DownloadNotAllowedException;
import Week3.Implementation.Users.Purchase;
import Week3.Implementation.Users.User;
import junit.framework.TestCase;

import java.time.LocalDate;

public class AppStoreTest extends TestCase {
    AppStore appleStore = new AppleAppStore("USD");
    AppStore googlePlayStore = new GoogleAppStore("EUR");

    App game1 = new App("ActionGame", 5.99, true, false);
    App game3 = new App("CasualGame", 1.99, false, false);
    App game4 = new App("MatureGame", 7.99, true, true);

    User user = new User("Charlie", "charlie@example.com", LocalDate.of(1985, 10, 5));

    public void testUploadApp() {
        try {
            appleStore.uploadApp(game1);
            System.out.println("Get the uploaded app: " + game1.getName());
            assertEquals(game1, appleStore.getApps().get(0));
        } catch (DownloadNotAllowedException e) {
            throw new RuntimeException(e);
        }
    }

    public void testCalculateTotalRevenue() {
        try {
            googlePlayStore.uploadApp(game3);
            googlePlayStore.uploadApp(game4);
            googlePlayStore.purchase(new Purchase(user, game3));
            googlePlayStore.purchase(new Purchase(user, game4));
            System.out.println("The size of the GooglePlayStore: " + googlePlayStore.getApps().size());
        } catch (DownloadNotAllowedException e) {
            throw new RuntimeException(e);
        }
        assertEquals(9.98, googlePlayStore.calculateTotalRevenue());
    }

    public void testCalculateRevenueForApp() {
        try {
            googlePlayStore.uploadApp(game3);
            System.out.println(game3.getName() + " " + game3.getPrice());
        } catch (DownloadNotAllowedException e) {
            throw new RuntimeException(e);
        }
        assertEquals(1.99, game3.getPrice());
    }
}