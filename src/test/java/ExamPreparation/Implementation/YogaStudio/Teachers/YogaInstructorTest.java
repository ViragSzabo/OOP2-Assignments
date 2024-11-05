package ExamPreparation.Implementation.YogaStudio.Teachers;

import ExamPreparation.Implementation.YogaStudio.Classes.YogaClass;
import ExamPreparation.Implementation.YogaStudio.Enums.Specialization;
import ExamPreparation.Implementation.YogaStudio.Management.YogaStudioManagement;
import junit.framework.TestCase;

import java.time.LocalDateTime;

public class YogaInstructorTest extends TestCase {
    YogaStudioManagement studio;
    Instructor instructor;
    YogaClass yogaClass;

    public void setUp() throws Exception {
        super.setUp();

        studio = new YogaStudioManagement();
        instructor = new YogaInstructor("John", "Doe",Specialization.VINYASA);
        yogaClass = new YogaClass("Morning Flow", instructor, LocalDateTime.now().plusDays(1), 10);

        studio.addInstructor(instructor);
        studio.addYogaClass(yogaClass);
    }

    public void testTeach() {
        instructor.teach(yogaClass);
        assertEquals("Morning Flow", yogaClass.getName());
    }
}