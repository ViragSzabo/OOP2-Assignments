package ExamPreparation.Implementation.YogaStudio.Management;

import ExamPreparation.Implementation.YogaStudio.Classes.YogaClass;
import ExamPreparation.Implementation.YogaStudio.Interfaces.Payable;
import ExamPreparation.Implementation.YogaStudio.Members.Member;
import ExamPreparation.Implementation.YogaStudio.Teachers.Instructor;

import java.util.ArrayList;
import java.util.List;

public class YogaStudioManagement {private List<Member> members;
    private List<YogaClass> yogaClasses;
    private List<Instructor> instructors;

    public YogaStudioManagement() {
        this.members = new ArrayList<>();
        this.yogaClasses = new ArrayList<>();
        this.instructors = new ArrayList<>();
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public List<YogaClass> getYogaClasses() {
        return yogaClasses;
    }

    public void setYogaClasses(List<YogaClass> yogaClasses) {
        this.yogaClasses = yogaClasses;
    }

    public void addMember(Member member) {
        this.members.add(member);
    }

    public void removeMember(Member member) {
        this.members.remove(member);
    }

    public void addInstructor(Instructor instructor) {
        this.instructors.add(instructor);
    }

    public void removeInstructor(Instructor instructor) {
        this.instructors.remove(instructor);
    }

    public void addYogaClass(YogaClass yogaClass) {
        this.yogaClasses.add(yogaClass);
    }

    public void removeYogaClass(YogaClass yogaClass) {
        this.yogaClasses.remove(yogaClass);
    }

    public boolean bookClass(Member member,YogaClass yogaClass) {
        return member.enrollFor(yogaClass);
    }

    public void makePayment(Payable payable, double amount) {
        payable.makePayment(amount);
    }
}