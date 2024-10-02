package Week3.Implementation.Apps;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DownloadNotAllowedExceptionTest {

    @Test
    public void testDownloadNotAllowedExceptionMessage() {
        try {
            throw new DownloadNotAllowedException("Download not allowed");
        } catch (DownloadNotAllowedException e) {
            assertEquals("Download not allowed", e.getMessage());
        }
    }

    @Test
    public void testDownloadNotAllowedExceptionIsThrown() {
        boolean exceptionThrown = false;
        try {
            throw new DownloadNotAllowedException("Download not allowed");
        } catch (DownloadNotAllowedException e) {
            exceptionThrown = true;
            assertEquals("Download not allowed", e.getMessage());
        }
        assertTrue("Expected DownloadNotAllowedException to be thrown", exceptionThrown);
    }
}