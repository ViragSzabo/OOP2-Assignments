package ExamPreparation.Implementation.SmartBBQ;

public class BBQ {
    public static void main(String[] args) throws NoMoreFoodException, FridgeIsEmptyException {
        SmartBBQ bbq = new SmartBBQ();
        Fridge fridge = Fridge.getInstance();

        // Add food to fridge
        fridge.addFood(new Corn());
        fridge.addFood(new BellPepper());
        fridge.addFood(new Hamburger());
        fridge.addFood(new Sausage());

        // Add food to BBQ
        bbq.addFood(fridge.getNextMeat(), 0);
        bbq.addFood(fridge.getNextMeat(), 1);
        bbq.addFood(fridge.getNextVegetable(), 2);

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