package Week1.Hospital.Implementation.System;

import static org.junit.Assert.assertArrayEquals;
import junit.framework.TestCase;

public class StatusTest extends TestCase {

    public void testValues() {
        // Expected enum constants
        Status[] expectedValues = { Status.NORMAL, Status.WARNING, Status.CRITICAL };

        // Retrieve the actual enum constants
        Status[] actualValues = Status.values();

        // Verify that the actual values match the expected values
        assertArrayEquals(expectedValues, actualValues);
    }

    public void testValueOf() {
        // Test valid names
        assertEquals(Status.NORMAL, Status.valueOf("NORMAL"));
        assertEquals(Status.WARNING, Status.valueOf("WARNING"));
        assertEquals(Status.CRITICAL, Status.valueOf("CRITICAL"));

        // Test invalid name to ensure it throws an exception
        try {
            Status.valueOf("INVALID");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Validate the exception message if needed
            assertEquals("No enum constant Week1.Hospital.Implementation.System.Status.INVALID", e.getMessage());
        }
    }
}