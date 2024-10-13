package Week1.Hospital.Implementation.Device;

public class BloodPressureRecord {
    private int systolic;
    private int diastolic;

    public BloodPressureRecord(int systolic, int diastolic) {
        this.systolic = systolic;
        this.diastolic = diastolic;
    }

    public String calculateStatus() {
        if (systolic > 180 || diastolic > 110) return "CRITICAL";
        if (systolic > 140 || systolic < 120 || diastolic > 90 || diastolic < 80) return "WARNING";
        return "NORMAL";
    }

    public int getSystolic() {
        return systolic;
    }

    public void setSystolic(int systolic) {
        this.systolic = systolic;
    }

    public int getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(int diastolic) {
        this.diastolic = diastolic;
    }
}