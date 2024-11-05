package ExamPreparation.Implementation.YogaStudio.Members;

import ExamPreparation.Implementation.YogaStudio.Classes.YogaClass;
import ExamPreparation.Implementation.YogaStudio.Enums.Membership;

public class Trial extends Member {
    public Trial(String firstName, String lastName) {
        super(firstName, lastName, Membership.DROP_IN);
    }

    @Override
    public void attendClass(YogaClass yogaClass) {
        System.out.println(this.getFullName() + " is attending at the " + yogaClass.getName());
    }
}