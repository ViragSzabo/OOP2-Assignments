package Week4.Implementation.EndAssignment.Rooms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SuiteTest {

    @Test
    public void testSuitePriceCalculationWithJacuzzi() {
        Suite suite = new Suite(30, true); // Suite with jacuzzi
        double expectedPrice = (30 * 15) + 50; // €15 per night per area + €50 for jacuzzi
        assertEquals(expectedPrice, suite.calculatePrice());
    }

    @Test
    public void testSuitePriceCalculationWithoutJacuzzi() {
        Suite suite = new Suite(30, false); // Suite without jacuzzi
        double expectedPrice = 30 * 15; // €15 per night per area
        assertEquals(expectedPrice, suite.calculatePrice());
    }
}