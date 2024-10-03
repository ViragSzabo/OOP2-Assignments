package ExamPreparation.Implementation.SmartBBQ.Meal;

import ExamPreparation.Implementation.SmartBBQ.Enums.Types;
import ExamPreparation.Implementation.SmartBBQ.Exceptions.NoMoreFoodException;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertThrows;

public class FridgeTest extends TestCase {
    private Fridge fridge;

    @BeforeEach
    public void setUp() {
        fridge = Fridge.getInstance();
        fridge.clearMeats();
    }

    @Test
    public void testGetNextMeatWhenAvailable() {
        try {
            Meat meat = new Meat(Types.COW);
            fridge.addFood(meat);
            Meat nextMeat = (Meat) fridge.getNextMeat();
            assertNotNull(nextMeat);
            assertEquals(meat, nextMeat);
        } catch (NoMoreFoodException e) {
            e.getMessage();
        }
    }

    @Test
    public void testGetNextMeatWhenNotAvailable() {
        assertThrows(NoMoreFoodException.class, () -> {
            fridge.getNextMeat();
        });
    }
}