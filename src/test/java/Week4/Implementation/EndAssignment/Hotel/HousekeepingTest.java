package Week4.Implementation.EndAssignment.Hotel;

import junit.framework.TestCase;

import java.util.ArrayList;

public class HousekeepingTest extends TestCase {
    private Housekeeping housekeeping = new Housekeeping();

    public void testGetActivityList() {
        housekeeping.addActivity("Eat");
        housekeeping.addActivity("Drink");
        housekeeping.addActivity("Hiking");
        assertEquals(3, housekeeping.getActivityList().size());
    }

    public void testSetActivityList() {
        housekeeping.setActivityList(new ArrayList<String>());
        assertEquals(0, housekeeping.getActivityList().size());
    }

    public void testAddActivity() {
        housekeeping.addActivity("Test");
        assertEquals(1, housekeeping.getActivityList().size());
    }
}