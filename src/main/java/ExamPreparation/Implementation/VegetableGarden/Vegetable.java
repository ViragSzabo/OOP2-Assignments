package ExamPreparation.Implementation.VegetableGarden;

public abstract class Vegetable {
    protected String color;
    protected double size; // in cm
    protected double sunshineGrowthFactor;
    protected double waterGrowthFactor;
    protected String status; // growing, ready to harvest, destroyed

    public Vegetable(String color, double sunshineGrowthFactor, double waterGrowthFactor) {
        this.color = color;
        this.size = 0;
        this.sunshineGrowthFactor = sunshineGrowthFactor;
        this.waterGrowthFactor = waterGrowthFactor;
        this.status = "growing";
    }

    public abstract void grow(double sunshine, double water);

    public String getStatus() {
        return this.status;
    }

    public double getSize() {
        return this.size;
    }
}