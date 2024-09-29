package Week2.Implementation.UserValidation.Validation;

import Week2.Implementation.UserValidation.User.User;
import Week2.Implementation.UserValidation.ValidationRule;

import java.util.Calendar;

public class AgeValidation implements ValidationRule {
    private int minAge;

    public AgeValidation(int minAge) {
        this.minAge = minAge;
    }

    @Override
    public boolean isValid(User user) throws ValidationException {
        Calendar today = Calendar.getInstance();
        Calendar birthDate = Calendar.getInstance();
        birthDate.setTime(user.getDateOfBirth());

        int age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);
        if(today.get(Calendar.MONTH) > birthDate.get(Calendar.MONTH)) {
            age--;
        }
        if(age < minAge) {
            throw new ValidationException("Age must be between " + minAge + " and " + age + ".");
        }
        return true;
    }
}