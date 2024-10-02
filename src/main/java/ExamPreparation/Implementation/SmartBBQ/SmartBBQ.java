package ExamPreparation.Implementation.SmartBBQ;

import java.util.Timer;
import java.util.TimerTask;

public class SmartBBQ {
    private int temperature;
    private boolean isOn = false;
    private final Food[] foodItems = new Food[6];
    private Timer timer;

    public void turnOn(int temp) {
        if (temp <= 250) {
            this.temperature = temp;
            this.isOn = true;
            startGrilling();
        }
    }

    private void startGrilling() {
        timer = new Timer();
        timer.schedule(new GrillTask(), 0, 1000); // Grill every second
    }

    public void setTemperature(int i) {
    }

    public Object getFood(int i) {
        return foodItems[i];
    }

    public int getTemperature() {
        return temperature;
    }

    class GrillTask extends TimerTask {
        @Override
        public void run() {

        }
    }

    public void addFood(Food food, int index) {
        if (index < 6) {
            foodItems[index] = food;
        }
    }
}