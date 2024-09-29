package Week4.Implementation.EndAssignment.Rooms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NormalTest {

    @Test
    public void testNormalRoomPriceCalculation() {
        Normal normalRoom = new Normal(20);
        double expectedPrice = 20 * 10; // €10 per night per area
        assertEquals(expectedPrice, normalRoom.calculatePrice());
    }
}