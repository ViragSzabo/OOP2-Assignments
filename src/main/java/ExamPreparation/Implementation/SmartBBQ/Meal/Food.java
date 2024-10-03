package ExamPreparation.Implementation.SmartBBQ.Meal;

public abstract class Food {
    public double tanningPercentage;
    public double temperature;
    public abstract void grill(double bqqTemperature);

    public double getTemperature() {
        return temperature;
    }

    public abstract String toString();
}