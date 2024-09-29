package ExamPreparation.Implementation.NuclearPowerplant.Reactors;

import ExamPreparation.Implementation.NuclearPowerplant.MeltdownException;

public class NuclearPowerPlant {
    private Reactor reactor;
    private Generator generator;
    private CoolingSystem coolingSystem;
    private ControlRoom controlRoom;

    public NuclearPowerPlant() {
        reactor = new Reactor();
        generator = new Generator();
        coolingSystem = new CoolingSystem();
        controlRoom = new ControlRoom(reactor, generator, coolingSystem);
    }

    public double run(double temperature, double time) throws MeltdownException {
        double[] results = reactor.splitAll(temperature, time);
        double residualHeat = results[0];
        double steam = results[1];

        double energyGenerated = generator.generateEnergy(steam);
        coolingSystem.abductResidualHeat(residualHeat);

        return energyGenerated;
    }

    public ControlRoom getControlRoom() {
        return controlRoom;
    }
}