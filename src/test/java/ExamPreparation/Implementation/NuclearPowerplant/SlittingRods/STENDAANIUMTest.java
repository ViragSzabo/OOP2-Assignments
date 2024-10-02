package ExamPreparation.Implementation.NuclearPowerplant.SlittingRods;

import ExamPreparation.Implementation.NuclearPowerplant.MeltdownException;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class STENDAANIUMTest extends TestCase {
    private STENDAANIUM s;

    @Before
    public void setUp() throws Exception {
        s = new STENDAANIUM();
    }

    @Test
    public void testSplit() {
        try {
            double[] result = s.split(1000, 1);
            assertNotNull(result);
            assertEquals(6666666.67, result[0], 0.01);
            assertEquals(50.0, result[1], 0.01);
        } catch (MeltdownException e) {
            fail("Unexpected MeltdownException for edge temperature");
        }
    }
}