package ExamPreparation.Implementation.YogaStudio;

import ExamPreparation.Implementation.YogaStudio.Classes.*;
import ExamPreparation.Implementation.YogaStudio.Enums.*;
import ExamPreparation.Implementation.YogaStudio.Management.YogaStudioManagement;
import ExamPreparation.Implementation.YogaStudio.Members.*;
import ExamPreparation.Implementation.YogaStudio.Teachers.*;
import junit.framework.TestCase;

import java.time.LocalDateTime;

public class YogaStudioManagementTest extends TestCase {
    YogaStudioManagement studio;
    Instructor instructor;
    YogaClass yogaClass;
    Member member;

    public void setUp() throws Exception {
        super.setUp();

        studio = new YogaStudioManagement();
        instructor = new YogaInstructor("John", "Doe", Specialization.VINYASA);
        yogaClass = new YogaClass("Morning Flow", instructor, LocalDateTime.now().plusDays(1), 10);
        member = new Standard("Alice", "Smith");

        studio.addMember(member);
        studio.addInstructor(instructor);
        studio.addYogaClass(yogaClass);
    }

    public void testBookClass() {
        studio.bookClass(member, yogaClass);
        assertTrue(member.enrollFor(yogaClass));
    }

    public void testMakePayment() {
        studio.makePayment(member, 50);
        studio.makePayment(instructor, 150);
        assertEquals(50.0, member.getBalance());
        assertEquals(150.0, instructor.getSalary());
    }
}