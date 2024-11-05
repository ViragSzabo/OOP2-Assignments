package ExamPreparation.Implementation.YogaStudio.Members;

import ExamPreparation.Implementation.YogaStudio.Classes.YogaClass;
import ExamPreparation.Implementation.YogaStudio.Enums.Membership;

public class Student extends Member {
    public Student(String firstName, String lastName) {
        super(firstName, lastName, Membership.CLASS_PASS);
    }

    @Override
    public void attendClass(YogaClass yogaClass) {
        System.out.println(this.getFullName() + " is attending at the " + yogaClass.getName());
    }
}