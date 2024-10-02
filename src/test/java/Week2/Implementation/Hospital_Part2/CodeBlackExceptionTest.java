package Week2.Implementation.Hospital_Part2;

import junit.framework.TestCase;

public class CodeBlackExceptionTest extends TestCase {
    public void testCodeBlackExceptionMessage() {
        try {
            throw new CodeBlackException("Test exception message");
        } catch (CodeBlackException e) {
            assertEquals("Test exception message", e.getMessage());
        }
    }

    public void testCodeBlackExceptionIsThrown() {
        boolean exceptionThrown = false;
        try {
            // Simulate the condition where the exception should be thrown
            throw new CodeBlackException("Test exception message");
        } catch (CodeBlackException e) {
            exceptionThrown = true;
            assertEquals("Test exception message", e.getMessage());
        }
        assertTrue("Expected CodeBlackException to be thrown", exceptionThrown);
    }
}