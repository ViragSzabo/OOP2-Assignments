package ExamPreparation.Implementation.VegetableGarden;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AsparagusTest {
    private Asparagus a;

    @Before
    public void setUp() {
        a = new Asparagus();
    }

    @Test
    public void testGrow() {
        assertEquals(0.0, a.getSize());

        a.grow(5000, 10);
        assertEquals(0.0, a.getSize());

        a.grow(5000, 20);
        assertEquals(0.23299999999999998, a.getSize());

        a.grow(5000, 30);
        assertEquals(0.5149999999999999, a.getSize());

        a.grow(5000, 40);
        assertEquals(0.8459999999999999, a.getSize());
    }

    @Test
    public void testGrowMinimalConditions() {
        a.grow(100, 0);
        assertEquals(0.0, a.getSize());
    }
}