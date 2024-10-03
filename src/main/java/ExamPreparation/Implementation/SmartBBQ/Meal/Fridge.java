package ExamPreparation.Implementation.SmartBBQ.Meal;

import ExamPreparation.Implementation.SmartBBQ.Exceptions.NoMoreFoodException;

import java.util.LinkedList;
import java.util.Queue;

public class Fridge { // Implement Singleton Pattern
    private static Fridge instance;
    private final Queue<Meat> meats = new LinkedList<>();
    private final Queue<Vegetable> vegetables = new LinkedList<>();
    private double temperature = 8;

    private Fridge() {}

    public static Fridge getInstance() {
        if (instance == null) {
            instance = new Fridge();
        }
        return instance;
    }

    public Food getNextMeat() throws NoMoreFoodException {
        Meat meat = meats.poll();
        if(meat != null) {
            return meat;
        } else {
            throw new NoMoreFoodException("No more meat available!");
        }
    }

    public Food getNextVegetable() throws NoMoreFoodException {
        Vegetable vegetable = vegetables.poll();
        if(vegetable != null) {
            return vegetable;
        } else {
            throw new NoMoreFoodException("No more vegetable available!");
        }
    }

    public void addFood(Food food) {
        if(food instanceof Meat) {
            meats.add((Meat) food);
        } else if (food instanceof Vegetable) {
            vegetables.add((Vegetable) food);
        }
    }

    public void setTemperature(double temp) {
        this.temperature = temp;
    }

    public double getTemperature() {
        return temperature;
    }

    public void clearMeats() {
        meats.clear();
        vegetables.clear();
    }
}