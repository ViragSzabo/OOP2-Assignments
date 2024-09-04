package Week1.Example;

public class Bird extends Animal
{
    public Bird(String name, int iq)
    {
        super(name, iq);
    }

    @Override
    public String getSound()
    {
        return "KAR KAR KAR";
    }

    public String fly()
    {
        return "Flying around.";
    }
}