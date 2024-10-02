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
        for (int i = 0; i < 3; i++) {
            fridge.addFood(new Corn());
        }
        for (int i = 0; i < 2; i++) {
            fridge.addFood(new BellPepper());
        }
        for (int i = 0; i < 2; i++) {
            fridge.addFood(new Hamburger());
        }
        for (int i = 0; i < 3; i++) {
            fridge.addFood(new Sausage());
        }

        try {
            for (int i = 0; i < 3; i++) {
                bbq.addFood(fridge.getNextMeat(), i);
            }
        } catch (NoMoreFoodException | FridgeIsEmptyException e) {
            throw new RuntimeException("Error while adding meat to BBQ", e);
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