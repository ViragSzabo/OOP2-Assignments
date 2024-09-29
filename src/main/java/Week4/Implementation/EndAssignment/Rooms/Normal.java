package Week4.Implementation.EndAssignment.Rooms;

public class Normal extends Room {
    public Normal(double area) {
        super(area);
        this.pricePerNight = 10;
    }

    @Override
    public double calculatePrice() {
        return area * pricePerNight;
    }
}