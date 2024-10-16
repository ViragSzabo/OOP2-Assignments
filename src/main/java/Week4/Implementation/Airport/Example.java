package Week4.Implementation.Airport;

import Week4.Implementation.Airport.Airplane.CommercialAirplane;
import Week4.Implementation.Airport.Airplane.PrivateAirplane;
import Week4.Implementation.Airport.Flight.Flight;
import Week4.Implementation.Airport.Flight.FlightBookingSystem;
import Week4.Implementation.Airport.Flight.Flight24Uploader;
import Week4.Implementation.Airport.Luggage.Luggage;
import Week4.Implementation.Airport.Luggage.LuggageType;
import Week4.Implementation.Airport.Travel.Airport;
import Week4.Implementation.Airport.Travel.Passenger;
import Week4.Implementation.Airport.Travel.Booking;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;

public class Example {
    public static void main(String[] args) {
        // 1. Create Airports
        Airport jfk = new Airport("JFK");
        Airport amx = new Airport("AMX");
        Airport mex = new Airport("MEX");
        Airport lax = new Airport("LAX");

        // Define distances
        jfk.addDistance(String.valueOf(amx), 5848);
        jfk.addDistance(String.valueOf(mex), 3366);
        jfk.addDistance(String.valueOf(lax), 3975);
        amx.addDistance(String.valueOf(mex), 9206);
        amx.addDistance(String.valueOf(lax), 8956);
        mex.addDistance(String.valueOf(lax), 2500);

        // 2. Create Airplanes
        PrivateAirplane privatePlane = new PrivateAirplane("PVT123", 5000, 10);
        CommercialAirplane commercialPlane = new CommercialAirplane("COM456", 15000, 100, 20);

        // 3. Create Flights
        Flight flight1 = new Flight(privatePlane, jfk, mex, LocalDateTime.of(2023, 9, 26, 12, 54));
        Flight flight2 = new Flight(commercialPlane, amx, lax, LocalDateTime.of(2023, 10, 1, 15, 30));

        // 4. Initialize FlightBookingSystem
        FlightBookingSystem bookingSystem = new FlightBookingSystem();
        bookingSystem.addFlight(flight1);
        bookingSystem.addFlight(flight2);

        // 5. Create Users and Passengers
        Passenger passenger1 = new Passenger("Alice", "alice@example.com", "1234567890");
        passenger1.setLuggage(new Luggage(15.0, LuggageType.CARRY_ON));
        passenger1.setLuggage(new Luggage(25.0, LuggageType.HOLD));

        Passenger passenger2 = new Passenger("Bob", "bob@example.com", "0987654321");
        passenger2.setLuggage(new Luggage(10.0, LuggageType.CARRY_ON));

        Passenger passenger3 = new Passenger("Charlie", "charlie@example.com", "5555555555");
        passenger3.setLuggage(new Luggage(20.0, LuggageType.HOLD));

        // 6. Create and Add Bookings
        try {
            Booking booking1 = bookingSystem.createBooking(flight1, Arrays.asList(passenger1, passenger2));
            System.out.println("Booking1 created successfully.");

            Booking booking2 = bookingSystem.createBooking(flight2, Collections.singletonList(passenger3));
            System.out.println("Booking2 created successfully.");

        } catch (Exception e) {
            System.out.println("Error creating booking: " + e.getMessage());
        }

        // 7. Depart Flights
        try {
            flight1.departFlight();
            System.out.println("Flight1 has departed.");
        } catch (Exception e) {
            System.out.println("Error departing flight1: " + e.getMessage());
        }

        // 8. Upload Data using Flight24Uploader
        Flight24Uploader uploader = new Flight24Uploader();
        uploader.uploadFlightData(flight1);
        uploader.uploadAirplaneData(privatePlane);

        uploader.uploadFlightData(flight2);
        uploader.uploadAirplaneData(commercialPlane);

        // 9. Calculate and Display Revenue
        System.out.println("Total revenue for Private Plane Flight1: $" + flight1.getAirplane().getFuelUsage(flight1));
        System.out.println("Total revenue for Commercial Plane Flight2: $" + flight2.getAirplane().getFuelUsage(flight2));

        // 10. Get Flight Information
        System.out.println(flight1.getFlightInfo());
        System.out.println(flight2.getFlightInfo());

        // 11. View Reservations for a User
        System.out.println("Reservations for Alice:");
        bookingSystem.viewReservations(passenger1).forEach(booking ->
                 System.out.println(booking.getFlight().getFlightInfo()));

        System.out.println("Reservations for Bob:");
        bookingSystem.viewReservations(passenger2).forEach(booking ->
                System.out.println(booking.getFlight().getFlightInfo()));

        System.out.println("Reservations for Charlie:");
        bookingSystem.viewReservations(passenger3).forEach(booking ->
                 System.out.println(booking.getFlight().getFlightInfo()));
    }
}