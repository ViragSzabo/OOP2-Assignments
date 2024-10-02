package ExamPreparation.Implementation.NuclearPowerplant.Reactors;

import ExamPreparation.Implementation.NuclearPowerplant.SlittingRods.SplittingRod;

public class ControlRoom {
    private final Reactor reactor;
    private final Generator generator;
    private final CoolingSystem coolingSystem;

    public ControlRoom(Reactor reactor, Generator generator, CoolingSystem coolingSystem) {
        this.reactor = reactor;
        this.generator = generator;
        this.coolingSystem = coolingSystem;
    }

    public String getReactorStatus() {
        for (SplittingRod rod : reactor.getSplittingRods()) {
            if (rod.getResidualPercentage() <= 0.2) {
                return "Needs Attention";
            }
        }
        return "Stable";
    }

    public String getCoolingSystemStatus() {
        double temp = coolingSystem.getWaterTemperature();
        if (temp >= 90) {
            return "Unstable";
        } else if (temp >= 80) {
            return "Needs Attention";
        }
        return "Stable";
    }

    public String getGeneratorStatus() {
        if (generator.getTotalEnergyProduced() > 560) {
            return "Needs Attention";
        }
        return "Stable";
    }

    public boolean isNuclearReactorStable() {
        return getReactorStatus().equals("Stable") && getCoolingSystemStatus().equals("Stable") && getGeneratorStatus().equals("Stable");
    }
}