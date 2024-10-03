package ExamPreparation.Implementation.SmartBBQ.Meal;

import ExamPreparation.Implementation.SmartBBQ.Enums.Types;

public class Meat extends Food {
    private Types type;
    private double cookingPercentage;

    public Meat(Types type) {
        this.type = type;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public double getCookingPercentage() {
        return cookingPercentage;
    }

    public void setCookingPercentage(double cookingPercentage) {
        this.cookingPercentage = cookingPercentage;
    }

    @Override
    public void grill(double bbqTemperature) {
        cookingPercentage += 1 * bbqTemperature;
        tanningPercentage += 1 * bbqTemperature;
        temperature *= 0.5;
    }

    @Override
    public String toString() {
        return type.toString();
    }
}