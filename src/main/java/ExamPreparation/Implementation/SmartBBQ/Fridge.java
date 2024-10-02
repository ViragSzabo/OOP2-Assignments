package ExamPreparation.Implementation.SmartBBQ;

import java.util.ArrayList;
import java.util.List;

public class Fridge {
    private static Fridge instance;
    private final List<Food> meats = new ArrayList<>();
    private final List<Food> vegetables = new ArrayList<>();
    private final List<Food> bellpeppers = new ArrayList<>();
    private final List<Food> corns = new ArrayList<>();
    private final List<Food> hamburgers = new ArrayList<>();
    private final List<Food> sausages = new ArrayList<>();

    private Fridge() {}

    public static Fridge getInstance() {
        if (instance == null) {
            instance = new Fridge();
        }
        return instance;
    }

    public Food getNextMeat() throws NoMoreFoodException, FridgeIsEmptyException {
        if (meats.isEmpty()) throw new FridgeIsEmptyException("No more meat!");
        return meats.remove(0);
    }

    public Food getNextVegetable() throws FridgeIsEmptyException {
        if (vegetables.isEmpty()) throw new FridgeIsEmptyException("No more vegetables!");
        return vegetables.remove(0);
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