package Week1.Hospital.Implementation.Device;

import Week1.Hospital.Implementation.Building.Gender;

import java.time.LocalDateTime;

public class HeartRateRecord {
    private int heartRate;
    private LocalDateTime timeStamp;

    public String calculateStatus(int heartRate, Gender gender) {
        if (gender == Gender.MALE) {
            if (heartRate < 60 || heartRate > 100) return "CRITICAL";
            if (heartRate > 75) return "WARNING";
            return "NORMAL";
        } else {
            if (heartRate < 70 || heartRate > 110) return "CRITICAL";
            if (heartRate > 80) return "WARNING";
            return "NORMAL";
        }
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}