package Week4.Implementation.Airport.Flight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Flight24Uploader {
    private List<Flight> flights;
    private String filePath;

    public Flight24Uploader(List<Flight> flights, String filePath) {
        this.flights = flights;
        this.filePath = filePath;
    }

    public void upload() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(getFlightData()); // Write the flight data to the file
            System.out.println("Flight data uploaded successfully to " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing flight data to file: " + e.getMessage());
        }
    }

    public String getFlightData() {
        StringBuilder data = new StringBuilder();
        for (Flight flight : flights) {
            data.append(flight.getFlightInfo()).append("\n");
        }
        return data.toString();
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}