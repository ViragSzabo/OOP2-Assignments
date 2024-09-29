package ExamPreparation.Implementation.NuclearPowerplant.SlittingRods;

import ExamPreparation.Implementation.NuclearPowerplant.MeltdownException;

public class NHLIUM extends SplittingRod {

    @Override
    public double[] split(double temperature, double time) throws MeltdownException {
        if (time > 60 && temperature > 100) {
            throw new MeltdownException("Meltdown risk: Time exceeds 60 seconds and temperature exceeds 100 Kelvin.");
        }
        if (residualPercentage < 0.1) {
            throw new MeltdownException("Meltdown risk: Residual percentage below 0.1%.");
        }

        double steam = (0.9 * time * Math.pow(residualPercentage, 2));
        double residualHeat = temperature * 3;

        residualPercentage -= 0.06 * time;

        return new double[]{residualHeat, steam};
    }
}