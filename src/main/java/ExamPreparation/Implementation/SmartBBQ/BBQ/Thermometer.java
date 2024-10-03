package ExamPreparation.Implementation.SmartBBQ.BBQ;

import ExamPreparation.Implementation.SmartBBQ.Enums.Classification;
import ExamPreparation.Implementation.SmartBBQ.Meal.Food;
import ExamPreparation.Implementation.SmartBBQ.Meal.Fridge;

public class Thermometer {
    public String measureTemperature(Object item) {
        double temperature = getTemperature(item);

        Classification classification;
        if (temperature < 10) {
            classification = Classification.COLD;
        } else if (temperature <= 70) {
            classification = Classification.MEDIUM;
        } else {
            classification = Classification.HOT;
        }

        return String.format("I measured a temperature of %.1f degrees Celsius, which is classified as %s.",
                temperature, classification);
    }

    private static double getTemperature(Object item) {
        double temperature;

        if (item instanceof SmartBBQ) {
            temperature = ((SmartBBQ) item).getTemperature();
        } else if (item instanceof Fridge) {
            temperature = ((Fridge) item).getTemperature();
        } else if (item instanceof Food) {
            temperature = ((Food) item).getTemperature(); // Assuming Food has a method to get its temperature
        } else {
            throw new IllegalArgumentException("Unsupported item type for temperature measurement.");
        }
        return temperature;
    }
}