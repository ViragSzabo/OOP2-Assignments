package ExamPreparation.Implementation.VegetableGarden;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class GardenTest {
    private Garden garden;

    @BeforeEach
    public void setUp() {
        garden = new Garden();
    }

    @Test
    public void testMaxVegetables() {
        try {
            for (int i = 0; i < 27; i++) {
                garden.plantVegetable(new Asparagus());
            }
        } catch (TooManyVegetablesException e) {
            fail("Should not have thrown TooManyVegetablesException for 30 vegetables");
        }

        try {
            garden.plantVegetable(new Asparagus());
            fail("Should have thrown TooManyVegetablesException when planting more than 30 vegetables");
        } catch (TooManyVegetablesException e) {
            assertEquals("Garden is full!", e.getMessage());
        }
    }
}