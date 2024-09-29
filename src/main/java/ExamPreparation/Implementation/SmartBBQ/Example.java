package ExamPreparation.Implementation.SmartBBQ;

public class Example {
    public static void main(String[] args) {
        SmartBBQ bbq = new SmartBBQ();
        Fridge fridge = Fridge.getInstance();

        // Add food to fridge
        fridge.addFood(new Corn());
        fridge.addFood(new BellPepper());
        fridge.addFood(new Hamburger());
        fridge.addFood(new Sausage());

        // Add food to BBQ
        try {
            bbq.addFood(fridge.getNextMeat(), 0);
        } catch (NoMoreFoodException | FridgeIsEmptyException e) {
            throw new RuntimeException(e);
        }
        try {
            bbq.addFood(fridge.getNextMeat(), 1);
        } catch (NoMoreFoodException | FridgeIsEmptyException e) {
            throw new RuntimeException(e);
        }
        try {
            bbq.addFood(fridge.getNextVegetable(), 2);
        } catch (FridgeIsEmptyException e) {
            throw new RuntimeException(e);
        }

        // Turn on BBQ
        bbq.turnOn(180);

        // Measure meat temperature
        Thermometer thermometer = new Thermometer();
        System.out.println(thermometer.measureTemperature(bbq.getFood(0)));

        // Increase BBQ temperature
        bbq.setTemperature(200);
        System.out.println(thermometer.measureTemperature(bbq.getFood(0)));
    }
}