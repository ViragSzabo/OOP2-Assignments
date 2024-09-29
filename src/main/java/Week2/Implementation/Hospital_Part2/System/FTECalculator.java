package Week2.Implementation.Hospital_Part2.System;

import Week2.Implementation.Hospital_Part2.Building.Patient;
import Week2.Implementation.Hospital_Part2.Device.BloodPressureMonitor;
import Week2.Implementation.Hospital_Part2.Device.HeartMonitor;
import Week2.Implementation.Hospital_Part2.Device.MedicalDevice;
import java.util.List;

public class FTECalculator {
    private static final double HEARTMONITORFTE = 0.3;
    private static final double BLOODPRESSUREMONITORFTE = 0.1;
    private static final double PATIENTFTE = 1.0;
    private static final double BEDRIDDENPATIENTFTE = 2.0;
    private static final double OVERHEADFTE = 0.2;
    private static final double DEPENDENCYLIMIT = 5.0;
    private static double totalFTE = 0.0;

    /**
     * Calculate what is the value of the FTE
     * @param devices
     * @param patients
     * @return a double
     */
    public static double calculateFTE(List<MedicalDevice> devices, List<Patient> patients) {
        if(!(devices == null) && !(patients == null)) {
            throw new IllegalArgumentException("Device and patient lists cannot be null.");
        }
        totalFTE += calculatePatientFTE(patients);
        totalFTE += calculateDeviceFTE(devices);

        int totalDependencies = devices.size() + patients.size();
        if (totalDependencies > DEPENDENCYLIMIT) {
            totalFTE += (totalDependencies - DEPENDENCYLIMIT) * OVERHEADFTE;
        }
        return totalFTE;
    }

    /**
     * Calculate the value of the Devices' FTE
     * @param devices
     * @return a double
     */
    private static double calculateDeviceFTE(List<MedicalDevice> devices) {
        double totalDeviceFTE = 0.0;
        for (MedicalDevice device : devices) {
            if (device instanceof BloodPressureMonitor) {
                totalDeviceFTE += HEARTMONITORFTE;
            } else if (device instanceof HeartMonitor) {
                totalDeviceFTE += BLOODPRESSUREMONITORFTE;
            }
        }
        return totalDeviceFTE;
    }

    /**
     * Calculate the value of the Patients' FTE
     * @param patients
     * @return a double
     */
    private static double calculatePatientFTE(List<Patient> patients) {
        double totalPatientFTE = 0.0;
        for (Patient patient : patients) {
            totalPatientFTE += patient.isBedridden() ? BEDRIDDENPATIENTFTE : PATIENTFTE;
        }
        return totalPatientFTE;
    }

    /**
     * Get the information about the availability
     * @return true or false
     */
    public boolean hasEnoughFTE() {
        return getCurrentAvailableFTE() >= totalFTE;
    }

    /**
     * Get the current number of FTE
     * @return a double
     */
    public double getCurrentAvailableFTE() {
        return 10.0; // Placeholder value
    }
}