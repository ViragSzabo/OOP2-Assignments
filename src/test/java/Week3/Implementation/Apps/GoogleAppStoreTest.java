package Week3.Implementation.Apps;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GoogleAppStoreTest extends TestCase {
    private GoogleAppStore googleAppStore;
    private App allowedApp;
    private App nudityApp;

    @Before
    public void setUp() throws Exception {
        googleAppStore = new GoogleAppStore("Google App Store", "USD");
        allowedApp = new App("Allowed App", 1.99, false, false);
        nudityApp = new App("Nudity App", 2.99, true, true);
        nudityApp.setContainsNudity(true);
    }

    @Test
    public void testAddApp() {
        try {
            googleAppStore.addApp(allowedApp);
            assertEquals(1, googleAppStore.getApps().size());
            assertEquals(allowedApp, googleAppStore.getApps().get(0));
        } catch (IllegalArgumentException e) {
            fail("Adding allowed app should not throw an exception: " + e.getMessage());
        }
    }

    @After
    public void tearDown() throws Exception {
        googleAppStore = null;
        allowedApp = null;
        nudityApp = null;
    }
}