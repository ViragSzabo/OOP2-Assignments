package ExamPreparation.Implementation.SmartBBQ.Meal;

public class Vegetable extends Food {
    private double moisturePercentage = 100;

    @Override
    public void grill(double bbqTemperature) {
        tanningPercentage += 0.03 * bbqTemperature;
        moisturePercentage -= 0.1 * bbqTemperature;
        temperature += 0.5;
    }

    @Override
    public String toString() {
        return "Veggies";
    }
}