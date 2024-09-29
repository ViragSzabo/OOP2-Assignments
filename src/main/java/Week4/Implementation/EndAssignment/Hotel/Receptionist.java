package Week4.Implementation.EndAssignment.Hotel;

import Week4.Implementation.EndAssignment.Guests.Booking;
import Week4.Implementation.EndAssignment.Guests.Guest;

public class Receptionist {
    public void checkIn(Guest guest, Booking booking) {
        System.out.println("Checking in guest: " + guest.getEmail());
        notifyHousekeeping(booking);
        notifyRestaurant(booking);
    }
    private void notifyHousekeeping(Booking booking) {
        System.out.println("Housekeeping notified for room: " + booking.getRoom());
    }

    private void notifyRestaurant(Booking booking) {
        System.out.println("Restaurant notified for guests: " +
                (booking.getChildrenCount() + booking.getGuestsUnder18Count() + booking.getAdultsCount()));
    }

    public void processPayment(Booking booking) {
        double totalPrice = booking.calculateTotalPrice();
        System.out.println("Total payment processed: €" + totalPrice);
    }
}