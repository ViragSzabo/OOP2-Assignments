package ExamPreparation.Implementation.VegetableGarden;

import java.util.List;

public class VeggieGarden {
    public static void main(String[] args) {
        Garden garden = new Garden();

        try {
            // Plant some vegetables
            garden.plantVegetable(new Asparagus());
            garden.plantVegetable(new Pepper());

            // Make the sun shine and rain over 10 days
            for (int i = 0; i < 10; i++) {
                int sunshine = WeatherGenerator.generateLux();
                int rain = WeatherGenerator.generateMm();
                garden.growAll(sunshine, rain);

                System.out.println("Day " + (i + 1) + ": Sunshine = " + sunshine + " lux, Rain = " + rain + " mm");
            }

            // Harvest all ready vegetables
            List<Vegetable> harvest = garden.harvest();
            System.out.println("Vegetables ready to harvest: " + harvest.size());

            for (Vegetable v : harvest) {
                System.out.println(v.getClass().getSimpleName() + " is ready with size " + v.getSize() + " cm");
            }

            // Test too many vegetables exception
            for (int i = 0; i < 28; i++) {
                garden.plantVegetable(new Asparagus()); // Will throw an exception after 27 vegetables
            }

        } catch (TooManyVegetablesException e) {
            System.out.println(e.getMessage());
        }
    }
}