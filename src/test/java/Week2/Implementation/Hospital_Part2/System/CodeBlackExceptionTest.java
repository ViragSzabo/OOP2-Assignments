package Week2.Implementation.Hospital_Part2.System;

import org.junit.Test;
import static org.junit.Assert.*;

public class CodeBlackExceptionTest {

    @Test
    public void testCodeBlackExceptionMessage() {
        String message = "This is a test exception";
        CodeBlackException exception = new CodeBlackException(message);
        assertEquals(message, exception.getMessage());
    }
}