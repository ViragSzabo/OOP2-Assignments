package Week1.Hospital.Implementation.System;

import Week1.Hospital.Implementation.Device.BloodPressureMonitor;
import Week1.Hospital.Implementation.Device.HeartMonitor;
import Week1.Hospital.Implementation.Device.MedicalDevice;
import Week1.Hospital.Implementation.Building.Patient;

import java.util.List;

public class FTECalculator {
    public static double calculateFTE(List<MedicalDevice> devices, List<Patient> patients) {
        double totalFTE = 0.0;

        // Calculate FTE based on devices
        for (MedicalDevice device : devices) {
            if (device instanceof HeartMonitor) {
                totalFTE += 0.3;
            } else if (device instanceof BloodPressureMonitor) {
                totalFTE += 0.1;
            }
        }

        // Calculate FTE based on patients
        for (Patient patient : patients) {
            totalFTE += patient.isBedridden() ? 2.0 : 1.0;
        }

        // Add overhead if more than 5 dependencies
        int totalDependencies = devices.size() + patients.size();
        if (totalDependencies > 5) {
            totalFTE += (totalDependencies - 5) * 0.2;
        }

        return totalFTE;
    }
}
