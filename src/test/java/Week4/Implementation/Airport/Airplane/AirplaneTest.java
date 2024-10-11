package Week4.Implementation.Airport.Airplane;

import org.junit.Test;
import static org.junit.Assert.*;

public class AirplaneTest {

    @Test
    public void testCommercialAirplaneFuelConsumption() {
        CommercialAirplane airplane = new CommercialAirplane("KLM123", 1000, 150, 50);
        double consumption = airplane.calculateFuelConsumption(1000, 10, 200);
        assertEquals(361560, consumption, 0.01);
    }

    @Test
    public void testPrivateAirplaneFuelConsumption() {
        PrivateAirplane airplane = new PrivateAirplane("Cessna123", 1000, 5);
        double consumption = airplane.calculateFuelConsumption(1000, 10, 200);
        assertEquals(6648.7, consumption, 0.01);
    }
}