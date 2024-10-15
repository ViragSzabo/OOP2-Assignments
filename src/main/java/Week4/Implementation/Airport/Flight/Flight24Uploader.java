package Week4.Implementation.Airport.Flight;

import Week4.Implementation.Airport.Airplane.Airplane;
import Week4.Implementation.Airport.Airplane.CommercialAirplane;
import Week4.Implementation.Airport.Airplane.PrivateAirplane;

import java.io.FileWriter;
import java.io.IOException;

public class Flight24Uploader {
    public void uploadFlightData(Flight flight) {
        String flightData = flight.getFlightInfo();
        try (FileWriter writer = new FileWriter("flight_data.txt", true)) {
            writer.write(flightData + "\n");
        } catch (IOException e) {
            System.out.println("Error writing flight data: " + e.getMessage());
        }
    }

    public void uploadAirplaneData(Airplane airplane) {
        String airplaneData;
        if (airplane instanceof PrivateAirplane) {
            PrivateAirplane pa = (PrivateAirplane) airplane;
            airplaneData = String.format("P: %s. %.2f liter fuel. %d empty seats.",
                    pa.getCode(), pa.getFuelLevel(), pa.getTotalSeats());
        } else if (airplane instanceof CommercialAirplane) {
            CommercialAirplane ca = (CommercialAirplane) airplane;
            int emptyEconomySeats = ca.getTotalSeats() - ca.getTotalSeats();
            int emptyBusinessSeats = ca.getTotalSeats() - ca.getTotalSeats();
            airplaneData = String.format("C: %s. %.2f liter fuel. %d economy seats, %d business seats.",
                    ca.getCode(), ca.getFuelLevel(), emptyEconomySeats, emptyBusinessSeats);
        } else {
            airplaneData = "Unknown airplane type.";
        }

        try (FileWriter writer = new FileWriter("airplane_data.txt", true)) {
            writer.write(airplaneData + "\n");
        } catch (IOException e) {
            System.out.println("Error writing airplane data: " + e.getMessage());
        }
    }
}