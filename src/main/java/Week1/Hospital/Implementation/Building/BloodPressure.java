package Week1.Hospital.Implementation.Building;

public class BloodPressure {
    private int systolic;
    private int diastolic;

    public BloodPressure(int systolic, int diastolic) {
        this.systolic = systolic;
        this.diastolic = diastolic;
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