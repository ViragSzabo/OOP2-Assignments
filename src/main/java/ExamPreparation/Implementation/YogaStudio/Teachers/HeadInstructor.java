package ExamPreparation.Implementation.YogaStudio.Teachers;

import ExamPreparation.Implementation.YogaStudio.Classes.YogaClass;
import ExamPreparation.Implementation.YogaStudio.Enums.Specialization;

public class HeadInstructor extends Instructor {
    public HeadInstructor(String firstName, String lastName, Specialization specialization) {
        super(firstName, lastName, specialization);
    }

    @Override
    public void teach(YogaClass yogaClass) {
        System.out.println(this.getFullName() + " is teaching " + yogaClass.getName());
    }
}