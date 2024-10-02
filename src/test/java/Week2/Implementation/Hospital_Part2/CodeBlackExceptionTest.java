package Week2.Implementation.Hospital_Part2;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CodeBlackExceptionTest {

    @Test
    public void testCodeBlackExceptionMessage() {
        try {
            throw new CodeBlackException("Test exception message");
        } catch (CodeBlackException e) {
            assertEquals("Test exception message", e.getMessage());
        }
    }

    @Test
    public void testCodeBlackExceptionIsThrown() {
        boolean exceptionThrown = false;
        try {
            throw new CodeBlackException("Test exception message");
        } catch (CodeBlackException e) {
            exceptionThrown = true;
            assertEquals("Test exception message", e.getMessage());
        }
        assertTrue("Expected CodeBlackException to be thrown", exceptionThrown);
    }
}