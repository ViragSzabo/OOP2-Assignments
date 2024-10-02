package ExamPreparation.Implementation.VegetableGarden;

import java.util.ArrayList;
import java.util.List;

public class Garden {
    private static final int MAX_VEGETABLES = 27;
    private final List<Vegetable> vegetables;

    public Garden() {
        vegetables = new ArrayList<>();
    }

    public void plantVegetable(Vegetable v) throws TooManyVegetablesException {
        if (vegetables.size() >= MAX_VEGETABLES) {
            throw new TooManyVegetablesException("Garden is full!");
        }
        vegetables.add(v);
    }

    public void growAll(double sunshine, double water) {
        for (Vegetable v : vegetables) {
            v.grow(sunshine, water);
        }
    }

    public List<Vegetable> harvest() {
        List<Vegetable> harvest = new ArrayList<>();
        for (Vegetable v : vegetables) {
            if ("ready to harvest".equals(v.getStatus())) {
                harvest.add(v);
            }
        }
        return harvest;
    }
}