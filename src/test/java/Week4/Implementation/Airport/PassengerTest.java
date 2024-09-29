package Week4.Implementation.Airport;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PassengerTest {
    private Passenger passenger1;
    private Passenger passenger2;
    private Passenger passenger3;

    @Before
    public void setUp() {
        // Initialize a Passenger object before each test
        passenger1 = new Passenger("YuLingWu", "yulingwucircle@example.com", "123456789");
        passenger2 = new Passenger("JoshBrubaker", "joshbrubakercircle@example.com", "987654321");
        passenger3 = new Passenger("Carol Franklin", "johnfranklincircle@example.com", "546372819");
    }

    @Test
    public void testTestGetName() {
        passenger1.getName();
        assertEquals("YuLingWu", passenger1.getName());
        passenger2.getName();
        assertEquals("JoshBrubaker", passenger2.getName());
        passenger3.getName();
        assertEquals("Carol Franklin", passenger3.getName());
    }

    @Test
    public void testTestSetName() {
        passenger1.setName("Yu Ling Wu");
        assertEquals("Yu Ling Wu", passenger1.getName());
        passenger2.setName("Josh Brubaker");
        assertEquals("Josh Brubaker", passenger2.getName());
        passenger3.setName("Carol");
        assertEquals("Carol", passenger3.getName());
    }

    @Test
    public void testGetEmail() {
        passenger1.getEmail();
        assertEquals("yulingwucircle@example.com", passenger1.getEmail());
        passenger2.getEmail();
        assertEquals("joshbrubakercircle@example.com", passenger2.getEmail());
        passenger3.getEmail();
        assertEquals("johnfranklincircle@example.com", passenger3.getEmail());
    }

    @Test
    public void testSetEmail() {
        passenger1.setEmail("yulingwu@example.com");
        assertEquals("yulingwu@example.com", passenger1.getEmail());
        passenger2.setEmail("joshbrubaker@example.com");
        assertEquals("joshbrubaker@example.com", passenger2.getEmail());
        passenger3.setEmail("carol@example.com");
        assertEquals("carol@example.com", passenger3.getEmail());
    }

    @Test
    public void testGetPhoneNumber() {
        passenger1.getPhoneNumber();
        assertEquals("123456789", passenger1.getPhoneNumber());
        passenger2.getPhoneNumber();
        assertEquals("987654321", passenger2.getPhoneNumber());
        passenger3.getPhoneNumber();
        assertEquals("546372819", passenger3.getPhoneNumber());
    }

    @Test
    public void testSetPhoneNumber() {
        passenger1.setPhoneNumber("(123) 456-7890");
        assertEquals("(123) 456-7890", passenger1.getPhoneNumber());
        passenger2.setPhoneNumber("(555) 012-3456");
        assertEquals("(555) 012-3456", passenger2.getPhoneNumber());
        passenger3.setPhoneNumber("(987) 654-3210");
        assertEquals("(987) 654-3210", passenger3.getPhoneNumber());
    }
}