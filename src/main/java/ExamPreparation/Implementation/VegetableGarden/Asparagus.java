package ExamPreparation.Implementation.VegetableGarden;

public class Asparagus extends Vegetable {
    private static final double MAX_SIZE = 20; // cm
    private static final double BREAKDOWN_RAIN = 14; // mm in 10 days

    public Asparagus() {
        super("blue", 0.000027, 0.0049);
    }

    @Override
    public void grow(double sunshine, double water) {
        if (water < BREAKDOWN_RAIN) {
            this.status = "destroyed";
        } else {
            this.size += (sunshine * this.sunshineGrowthFactor) + (water * this.waterGrowthFactor);
            if (this.size >= MAX_SIZE) {
                this.status = "ready to harvest";
            }
        }
    }
}