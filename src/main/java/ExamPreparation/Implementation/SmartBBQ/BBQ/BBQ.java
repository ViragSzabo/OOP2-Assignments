package ExamPreparation.Implementation.SmartBBQ.BBQ;

import ExamPreparation.Implementation.SmartBBQ.Exceptions.FridgeIsEmptyException;
import ExamPreparation.Implementation.SmartBBQ.Exceptions.NoMoreFoodException;
import ExamPreparation.Implementation.SmartBBQ.Meal.Fridge;
import ExamPreparation.Implementation.SmartBBQ.Meal.Meat;
import ExamPreparation.Implementation.SmartBBQ.Enums.Types;
import ExamPreparation.Implementation.SmartBBQ.Meal.Vegetable;

public class BBQ {
    public static void main(String[] args) throws NoMoreFoodException, FridgeIsEmptyException {
        SmartBBQ bbq = new SmartBBQ();
        Fridge fridge = Fridge.getInstance();

        // Add food to fridge
        fridge.addFood(new Vegetable());
        fridge.addFood(new Meat(Types.CHICKEN));
        fridge.addFood(new Meat(Types.PIG));
        fridge.addFood(new Meat(Types.COW));

        // Add food to BBQ
        bbq.addFood(fridge.getNextMeat());
        bbq.addFood(fridge.getNextVegetable());

        // Turn on BBQ
        bbq.turnOn(180);

        // Increase BBQ temperature
        bbq.setTemperature(200);
    }
}