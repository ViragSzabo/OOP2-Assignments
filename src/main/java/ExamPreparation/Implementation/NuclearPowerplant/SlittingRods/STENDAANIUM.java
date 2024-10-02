package ExamPreparation.Implementation.NuclearPowerplant.SlittingRods;

import ExamPreparation.Implementation.NuclearPowerplant.MeltdownException;

public class STENDAANIUM extends SplittingRod {
    @Override
    public double[] split(double temperature, double time) throws MeltdownException {
        if (temperature > 5000) {
            throw new MeltdownException("Temperature too high! Risk of meltdown.");
        }

        double steam = 50 * time;
        double residualHeat = (temperature * temperature) / 3 * 20;

        return new double[]{residualHeat, steam};
    }
}