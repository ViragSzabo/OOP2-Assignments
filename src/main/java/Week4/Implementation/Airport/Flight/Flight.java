package Week4.Implementation.Airport.Flight;

import Week4.Implementation.Airport.Airplane.Airplane;
import Week4.Implementation.Airport.Travel.Airport;

import java.time.LocalDateTime;

public class Flight {
    private Airplane airplane;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private LocalDateTime departureTime;
    private String status; // awaiting departure, boarding, departed, landed

    public Flight(Airplane airplane, Airport departure, Airport arrival, LocalDateTime departureTime) {
        this.airplane = airplane;
        this.departureAirport = departure;
        this.arrivalAirport = arrival;
        this.departureTime = departureTime;
        this.status = "awaiting departure";
    }

    public void depart() throws Exception {
        int distance = departureAirport.getDistance(arrivalAirport.getCode());
        double requiredFuel = airplane.calculateFuelConsumption(distance, 0, 0); // Provide seat/luggage details
        if (airplane.getCurrentFuelLevel() < requiredFuel) {
            throw new Exception("Not enough fuel for the flight.");
        }
        this.status = "departed";
    }

    public String getFlightInfo() {
        return String.format("F: %s -> %s. Departure %s.", departureAirport.getCode(), arrivalAirport.getCode(), departureTime.toString());
    }
}