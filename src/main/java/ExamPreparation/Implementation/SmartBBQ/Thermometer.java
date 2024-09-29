package ExamPreparation.Implementation.SmartBBQ;

public class Thermometer {
    public String measureTemperature(Object obj) {
        int temperature = 0;
        if (obj instanceof SmartBBQ) {
            temperature = ((SmartBBQ) obj).getTemperature();
        } else if (obj instanceof Food) {
            temperature = ((Food) obj).getTemperature();
        }
        String classification = classifyTemperature(temperature);
        return "I measured a temperature of " + temperature + " degrees Celsius. It is " + classification;
    }

    private String classifyTemperature(int temperature) {
        if (temperature < 10) return "cold";
        if (temperature <= 70) return "medium";
        return "hot";
    }
}