package ExamPreparation.Implementation.VegetableGarden;

public class Pepper extends Vegetable {
    private static final double MIN_SIZE = 15.0;
    private static final double MAX_SIZE = 21.0;
    private static final double BREAKDOWN_RAIN = 31.0; // mm in 4 days
    private static final double MIN_RAIN_TO_GROW = 25.0; // mm in 10 days

    public Pepper() {
        super("Pink", 0.000044, 0.0013);
    }

    @Override
    public void grow(double sunshine, double water) {
        if (water > BREAKDOWN_RAIN) {
            this.status = "destroyed";
        } else if (water < MIN_RAIN_TO_GROW) {
            return; // Doesn't grow due to insufficient rain
        } else {
            this.size += (sunshine * this.sunshineGrowthFactor) + (water * this.waterGrowthFactor);
            if (this.size >= MIN_SIZE && this.size <= MAX_SIZE) {
                this.status = "ready to harvest";
            }
        }
    }
}