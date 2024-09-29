package ExamPreparation.Implementation.SmartBBQ;

import java.util.ArrayList;
import java.util.List;

public class Fridge {
    private static Fridge instance;
    private List<Food> meats = new ArrayList<>();
    private List<Food> vegetables = new ArrayList<>();
    private List<Food> bellpeppers = new ArrayList<>();
    private List<Food> corns = new ArrayList<>();
    private List<Food> hamburgers = new ArrayList<>();
    private List<Food> sausages = new ArrayList<>();

    private Fridge() {}

    public static Fridge getInstance() {
        if (instance == null) {
            instance = new Fridge();
        }
        return instance;
    }

    public Food getNextMeat() throws NoMoreFoodException, FridgeIsEmptyException {
        if (meats.isEmpty()) throw new FridgeIsEmptyException("No more meat!");
        return (Meat) meats.remove(0);
    }

    public Food getNextVegetable() throws FridgeIsEmptyException {
        if (vegetables.isEmpty()) throw new FridgeIsEmptyException("No more vegetables!");
        return (Vegetable) vegetables.remove(0);
    }

    public void addFood(BellPepper corn) {
    }

    public void addFood(Hamburger hamburger) {
    }

    public void addFood(Corn corn) {
    }

    public void addFood(Sausage sausage) {
    }
}