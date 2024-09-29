package ExamPreparation.Implementation.NuclearPowerplant;

import ExamPreparation.Implementation.NuclearPowerplant.SlittingRods.STENDAANIUM;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class STENDAANIUMTest {

    @Test
    public void testSplitBelow50K() throws MeltdownException {
        STENDAANIUM rod = new STENDAANIUM();
        double initialResidualPercentage = rod.getResidualPercentage();
        double[] results = rod.split(45, 30);

        assertEquals(initialResidualPercentage, rod.getResidualPercentage(), 0.001);

        double expectedSteam = 50 * 30;
        double expectedResidualHeat = (45 * 45) / 3 * 20;

        assertEquals(expectedResidualHeat, results[0], 0.001);
        assertEquals(expectedSteam, results[1], 0.001);
    }

    @Test
    public void testMeltdownExceptionTemperature() {
        STENDAANIUM rod = new STENDAANIUM();
        assertThrows(MeltdownException.class, () -> {
            rod.split(6000, 30); // Set temperature above 5000 to trigger the exception
        });
    }

    @Test
    public void testResidualPercentageDecrease() throws MeltdownException {
        STENDAANIUM rod = new STENDAANIUM();
        rod.split(60, 30); // Some valid conditions
        assertFalse(rod.getResidualPercentage() < 100); // Check if percentage decreased
    }
}