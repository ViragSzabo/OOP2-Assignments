package Week4.Implementation.EndAssignment.Guests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuestTest {

    @Test
    public void testGuestCreation() {
        Guest guest = new Guest("John Doe", "123 Main St", "john@example.com", "+123456789");
        assertEquals("John Doe", guest.getName());
        assertEquals("123 Main St", guest.getAddress());
        assertEquals("john@example.com", guest.getEmail());
        assertEquals("+123456789", guest.getPhoneNumber());
    }
}