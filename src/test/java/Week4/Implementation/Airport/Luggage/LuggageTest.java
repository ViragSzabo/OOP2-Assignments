package Week4.Implementation.Airport.Luggage;

import junit.framework.TestCase;

public class LuggageTest extends TestCase {
    private Luggage luggage1;
    private Luggage luggage2;

    public void setUp() throws Exception {
        this.luggage1 = new Luggage(15.0, LuggageType.CARRY_ON);
        this.luggage2 = new Luggage(25.0, LuggageType.HOLD);
    }

    public void testGetWeight() {
        System.out.println("Luggage 1: " + luggage1.getWeight());
        System.out.println("Luggage 2: " + luggage2.getWeight());

        assertEquals(15.0, this.luggage1.getWeight(), 0);
        assertEquals(25.0, this.luggage2.getWeight(), 0);
    }

    public void testGetType() {
        System.out.println("Luggage 1: " + luggage1.getType());
        System.out.println("Luggage 2: " + luggage2.getType());

        assertEquals(LuggageType.CARRY_ON, this.luggage1.getType());
        assertEquals(LuggageType.HOLD, this.luggage2.getType());
    }

    public void testSetWeight() {
        System.out.println("Luggage 1: " + luggage1.getWeight());
        System.out.println("Luggage 2: " + luggage2.getWeight());

        this.luggage1.setWeight(25.0);
        assertEquals(25.0, this.luggage1.getWeight(), 0);

        this.luggage2.setWeight(15.0);
        assertEquals(15.0, this.luggage2.getWeight(), 0);

        System.out.println("Luggage 1: " + luggage1.getWeight());
        System.out.println("Luggage 2: " + luggage2.getWeight());
    }

    public void testSetType() {
        System.out.println("Luggage 1: " + luggage1.getType());
        System.out.println("Luggage 2: " + luggage2.getType());

        this.luggage2.setType(LuggageType.CARRY_ON);
        assertEquals(LuggageType.CARRY_ON, this.luggage2.getType());

        this.luggage1.setType(LuggageType.HOLD);
        assertEquals(LuggageType.HOLD, this.luggage1.getType());

        System.out.println("Luggage 1: " + luggage1.getType());
        System.out.println("Luggage 2: " + luggage2.getType());
    }
}