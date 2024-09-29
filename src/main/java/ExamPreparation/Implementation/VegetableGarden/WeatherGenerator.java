package ExamPreparation.Implementation.VegetableGarden;

import java.util.Random;

public class WeatherGenerator {
    public static int generateLux() {
        Random rand = new Random();
        return rand.nextInt(101593 - 1000) + 1000;
    }

    public static int generateMm() {
        Random rand = new Random();
        return rand.nextInt(49);
    }
}