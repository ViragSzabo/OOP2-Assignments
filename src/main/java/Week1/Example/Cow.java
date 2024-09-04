package Week1.Example;

public class Cow extends Animal
{
    private final int serialNumber;

    public Cow(String name, int iq, int serialNumber)
    {
        super(name, iq);
        this.serialNumber = serialNumber;
    }

    @Override
    public String getSound()
    {
        return "MOOO *eating grass* ";
    }

    @Override
    public String fly() {
        return "Does not fly.";
    }
}