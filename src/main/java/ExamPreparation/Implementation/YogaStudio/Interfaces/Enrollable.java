package ExamPreparation.Implementation.YogaStudio.Interfaces;

import ExamPreparation.Implementation.YogaStudio.Classes.YogaClass;

public interface Enrollable {
    boolean enrollFor(YogaClass yogaClass);
    boolean cancel(YogaClass yogaClass);
}