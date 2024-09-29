package ExamPreparation.Implementation.NuclearPowerplant.Reactors;

public class CoolingSystem {
    private double waterTemperature = 0;

    public double abductResidualHeat(double residualHeat) {
        waterTemperature = residualHeat * 0.4;
        return waterTemperature;
    }

    public double getWaterTemperature() {
        return waterTemperature;
    }
}