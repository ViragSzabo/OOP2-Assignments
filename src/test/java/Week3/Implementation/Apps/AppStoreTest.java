package Week3.Implementation.Apps;

import Week3.Implementation.Users.Purchase;
import Week3.Implementation.Users.User;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AppStoreTest {
    private AppStore appStore;
    private User user;
    private App app;

    @Before
    public void setUp() throws Exception {
        appStore = new AppStore("Test Store", "USD");
        user = new User("Boo", "boo.seventeen@gmail.com", LocalDate.of(1994, 5, 2)); // Adjust constructor as necessary
        app = new App("Test Store", 5.99, true, true);
        appStore.addApp(app);
    }

    @Test
    public void testGetName() {
        assertEquals("Test Store", appStore.getName());
    }

    @Test
    public void testSetName() {
        appStore.setName("New Test Store");
        assertEquals("New Test Store", appStore.getName());
    }

    @Test
    public void testGetCurrency() {
        assertEquals("USD", appStore.getCurrency());
    }

    @Test
    public void testSetCurrency() {
        appStore.setCurrency("EUR");
        assertEquals("EUR", appStore.getCurrency());
    }

    @Test
    public void testGetApps() {
        assertEquals(1, appStore.getApps().size());
        assertEquals(app, appStore.getApps().get(0));
    }

    @Test
    public void testSetApps() {
        List<App> newApps = new ArrayList<>();
        App anotherApp = new App("Another App", 1.99, false, false);
        newApps.add(anotherApp);
        appStore.setApps(newApps);
        assertEquals(newApps, appStore.getApps());
    }

    @Test
    public void testGetPurchases() {
        assertTrue(appStore.getPurchases().isEmpty());
    }

    @Test
    public void testSetPurchases() {
        List<Purchase> newPurchases = new ArrayList<>();
        appStore.setPurchases(newPurchases);
        assertEquals(newPurchases, appStore.getPurchases());
    }

    @Test
    public void testAddApp() {
        App newApp = new App("New App", 3.99, true, true);
        appStore.addApp(newApp);
        assertEquals(2, appStore.getApps().size());
        assertEquals(newApp, appStore.getApps().get(1));
    }

    @Test
    public void testPurchaseAppSuccess() throws DownloadNotAllowedException {
        appStore.purchaseApp(user, app);
        assertEquals(1, appStore.getPurchases().size());
        assertEquals(app, appStore.getPurchases().get(0).getApp());
    }

    @Test(expected = DownloadNotAllowedException.class)
    public void testPurchaseAppFailsDueToAge() throws DownloadNotAllowedException {
        User underageUser = new User("Young User", "young.user@example.com", LocalDate.of(2008, 1, 1));
        appStore.purchaseApp(underageUser, app);
        assertTrue(appStore.getPurchases().isEmpty());
    }

    @Test
    public void testCalculateTotalRevenue() throws DownloadNotAllowedException {
        appStore.purchaseApp(user, app);
        assertEquals(5.99, appStore.calculateTotalRevenue(), 0.001);
    }

    @Test
    public void testCalculateRevenueForApp() throws DownloadNotAllowedException {
        appStore.purchaseApp(user, app);
        assertEquals(0.0, appStore.calculateRevenueForApp("Test App"), 0.001);
    }

    @Test
    public void testCalculateRevenueForNonExistentApp() {
        assertEquals(0.0, appStore.calculateRevenueForApp("Nonexistent App"), 0.001);
    }
}