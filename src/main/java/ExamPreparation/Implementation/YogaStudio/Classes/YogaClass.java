package ExamPreparation.Implementation.YogaStudio.Classes;

import ExamPreparation.Implementation.YogaStudio.Members.Member;
import ExamPreparation.Implementation.YogaStudio.Teachers.Instructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class YogaClass {
    private String name;
    private Instructor instructor;
    private LocalDateTime dateTime;
    private int capacity;
    private List<Member> attendees;

    public YogaClass(String name, Instructor instructor, LocalDateTime dateTime, int capacity) {
        this.name = name;
        this.instructor = instructor;
        this.dateTime = dateTime;
        this.capacity = capacity;
        this.attendees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public List<Member> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<Member> attendees) {
        this.attendees = attendees;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean addAttendee(Member member) {
        if(this.attendees.size() < this.capacity) {
            this.attendees.add(member);
            return true;
        }
        return false; // The class is full
    }

    public boolean cancelledAttendee(Member member) {
        if(this.attendees.contains(member)) {
            this.attendees.remove(member);
            return true;
        }
        return false;
    }
}