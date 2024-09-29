package ExamPreparation.Implementation.NuclearPowerplant.Reactors;

public class Generator {
    private double totalEnergyProduced = 0.0;

    public double generateEnergy(double steam) {
        double energy = steam * 8.0;
        totalEnergyProduced += energy;
        return energy;
    }

    public double getTotalEnergyProduced() {
        return totalEnergyProduced;
    }
}