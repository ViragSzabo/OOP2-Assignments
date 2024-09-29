package Week4.Implementation.EndAssignment.Rooms;

public class Suite extends Room {
    private final boolean hasJacuzzi;

    public Suite(double area, boolean hasJacuzzi) {
        super(area);
        this.pricePerNight = 15; // Set to €15 per night for suites
        this.hasJacuzzi = hasJacuzzi;
    }

    @Override
    public double calculatePrice() {
        double price = area * pricePerNight; // Calculate price based on area

        if (hasJacuzzi) {
            price += 50; // Add €50 if the suite has a jacuzzi
        }
        return price;
    }
}