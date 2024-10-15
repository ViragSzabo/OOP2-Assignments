package Week2.Implementation.Hospital_Part2;

import java.util.HashMap;
import java.util.Map;

public class FTE {
    private static final double HEART_MONITOR_FTE = 0.3;
    private static final double BLOOD_PRESSURE_MONITOR_FTE = 0.1;
    private static final double PATIENT_FTE = 1.0;
    private static final double BEDRIDDEN_PATIENT_FTE = 2.0;
    private static final double OVERHEAD_FTE_PER_UNIT = 0.2;
    private Map<String, Integer> dependencies;

    public FTE() {
        dependencies = new HashMap<String, Integer>();
    }

    public void addDependency(String type, int count) {
        dependencies.put(type, dependencies.getOrDefault(type, 0) + count);
    }

    public double calculateTotalFTEs() {
        double totalFTEs = 0.0;
        int totalDependencies = 0;

        if (dependencies.containsKey("Heart Monitor")) {
            totalFTEs += HEART_MONITOR_FTE * dependencies.get("Heart Monitor");
            totalDependencies += dependencies.get("Heart Monitor");
        }

        if (dependencies.containsKey("Blood Pressure Monitor")) {
            totalFTEs += BLOOD_PRESSURE_MONITOR_FTE * dependencies.get("Blood Pressure Monitor");
            totalDependencies += dependencies.get("Blood Pressure Monitor");
        }

        if (dependencies.containsKey("Patient")) {
            totalFTEs += PATIENT_FTE * dependencies.get("Patient");
            totalDependencies += dependencies.get("Patient");
        }

        if (dependencies.containsKey("Bedridden Patient")) {
            totalFTEs += BEDRIDDEN_PATIENT_FTE * dependencies.get("Bedridden Patient");
            totalDependencies += dependencies.get("Bedridden Patient");
        }

        if (totalDependencies > 5) {
            totalFTEs += (totalDependencies * OVERHEAD_FTE_PER_UNIT);
        }

        return totalFTEs;
    }
}