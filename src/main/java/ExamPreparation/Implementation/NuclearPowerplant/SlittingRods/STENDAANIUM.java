package ExamPreparation.Implementation.NuclearPowerplant.SlittingRods;

import ExamPreparation.Implementation.NuclearPowerplant.MeltdownException;

public class STENDAANIUM extends SplittingRod {
    @Override
    public double[] split(double temperature, double time) throws MeltdownException {
        if (temperature > 5000) {
            throw new MeltdownException("Temperature too high! Risk of meltdown.");
        }

        // Your existing logic for calculating residual heat and steam
        double steam = 50 * time; // Example logic for steam generation
        double residualHeat = (temperature * temperature) / 3 * 20; // Example logic for residual heat

        return new double[]{residualHeat, steam};
    }
}