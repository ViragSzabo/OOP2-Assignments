package Week1.Hospital.Implementation.System;

import static org.junit.Assert.assertArrayEquals;
import junit.framework.TestCase;

public class StatusTest extends TestCase {

    public void testValues() {
        Status[] expectedValues = { Status.NORMAL, Status.WARNING, Status.CRITICAL };
        Status[] actualValues = Status.values();
        assertArrayEquals(expectedValues, actualValues);
    }

    public void testValueOf() {
        assertEquals(Status.NORMAL, Status.valueOf("NORMAL"));
        assertEquals(Status.WARNING, Status.valueOf("WARNING"));
        assertEquals(Status.CRITICAL, Status.valueOf("CRITICAL"));

        try {
            Status.valueOf("INVALID");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("No enum constant Week1.Hospital.Implementation.System.Status.INVALID", e.getMessage());
        }
    }
}