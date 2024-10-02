package Week3.Implementation.Apps;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AppleAppStoreTest extends TestCase {
    private AppleAppStore appleAppStore;
    private App allowedApp;
    private App nudityApp;

    @Before
    public void setUp() throws Exception {
        appleAppStore = new AppleAppStore("Apple App Store", "USD");
        allowedApp = new App("Allowed App", 1.99, false, false);
        nudityApp = new App("Nudity App", 2.99, true, true);
        nudityApp.setContainsNudity(true);
    }

    @Test
    public void testAddApp() {
        try {
            appleAppStore.addApp(allowedApp);
            assertEquals(1, appleAppStore.getApps().size());
            assertEquals(allowedApp, appleAppStore.getApps().get(0));
        } catch (IllegalArgumentException e) {
            fail("Adding allowed app should not throw an exception: " + e.getMessage());
        }
    }

    @After
    public void tearDown() throws Exception {
        appleAppStore = null;
        allowedApp = null;
        nudityApp = null;
    }
}