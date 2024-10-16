package ExamPreparation.Implementation.SmartBBQ.BBQ;

import ExamPreparation.Implementation.SmartBBQ.Meal.Food;

import java.util.Timer;
import java.util.TimerTask;

public class SmartBBQ {
    private int temperature;
    private boolean isOn = false;
    private final Food[] foodItems = new Food[6];
    private Timer bbqTimer;

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public Object getFood(int i) {
        return foodItems[i];
    }

    public int getTemperature() {
        return temperature;
    }

    public void turnOn(int temp) throws IllegalArgumentException {
        if (temperature > 250) {
            this.temperature = temp;
            this.isOn = true;
            System.out.println("Turning on " + this.temperature + "°C");
            startGrilling();
        } else {
            throw new IllegalArgumentException("Max temperature must be 250°C");
        }
    }

    public void turnOff(int temp) {
        isOn = false;
        if(bbqTimer != null) {
            bbqTimer.cancel();
        }
        System.out.println("SmartBBQ is turned off.");
    }

    private void startGrilling() {
        bbqTimer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                grillFoodItems();
            }
        };
        bbqTimer.scheduleAtFixedRate(task, 0, 1000);
    }

    public void addFood(Food food) throws IllegalStateException {
        for(int i = 0; i < foodItems.length; i++) {
            if(foodItems[i] == null) {
                foodItems[i] = food;
                System.out.println("Added: " + food);
                return;
            }
        }
        throw new IllegalStateException("No space available on SmartBBQ.");
    }

    public void increaseTemperature(int newTemp) {
        if (newTemp > 250) throw new IllegalArgumentException("Max temperature is 250°C");
        this.temperature = newTemp;
        System.out.println("Temperature increased to " + newTemp + "°C.");
    }

    public void grillFoodItems() {
        if(isOn) {
            for(Food food : foodItems) {
                if(food != null) {
                    food.grill(temperature);
                    System.out.println(food + "is being grilled.");
                }
            }
        }
    }
}