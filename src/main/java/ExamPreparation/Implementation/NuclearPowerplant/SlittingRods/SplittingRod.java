package ExamPreparation.Implementation.NuclearPowerplant.SlittingRods;

import ExamPreparation.Implementation.NuclearPowerplant.MeltdownException;

public abstract class SplittingRod {
    protected double residualPercentage = 100.0;

    public abstract double[] split(double temperature, double time) throws MeltdownException;
    public double getResidualPercentage() {
        return residualPercentage;
    }
}