package Week1.Example;

abstract class Animal
{
    private final String name;
    private final int iq;

    public Animal(String name, int iq)
    {
        this.name = name;
        this.iq = iq;
    }

    public String getName()
    {
        return this.name;
    }

    public int getIq()
    {
        return this.iq;
    }

    public void sleep()
    {
        System.out.println("I go sleeeep");
    }

    public void printAnimalInfo() {
        System.out.println("Animal name: " + getName());
        System.out.println("IQ: " + getIq());
    }

    public abstract String getSound();

    public abstract String fly();
}