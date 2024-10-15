package Week4.Implementation.Airport.Travel;

import Week4.Implementation.Airport.Airplane.Airplane;
import Week4.Implementation.Airport.Flight.Flight;
import Week4.Implementation.Airport.Luggage.Luggage;
import Week4.Implementation.Airport.Luggage.LuggageType;

import java.time.LocalDateTime;

public class Passenger {
    private String name;
    private String email;
    private String phoneNumber;
    private Luggage luggage;

    public Passenger(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.luggage = new Luggage(10, LuggageType.CARRY_ON);
    }

    public void bookFlight(Airplane airplane, Airport departure, Airport arrival, LocalDateTime time) {
        new Booking(new Flight(airplane, departure, arrival, time));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Luggage getLuggage() {
        return this.luggage;
    }

    public void setLuggage(Luggage luggage) {
        this.luggage = luggage;
    }
}