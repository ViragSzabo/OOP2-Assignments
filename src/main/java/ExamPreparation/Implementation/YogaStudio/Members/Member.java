package ExamPreparation.Implementation.YogaStudio.Members;

import ExamPreparation.Implementation.YogaStudio.Enums.Membership;
import ExamPreparation.Implementation.YogaStudio.Interfaces.Description;
import ExamPreparation.Implementation.YogaStudio.Interfaces.Enrollable;
import ExamPreparation.Implementation.YogaStudio.Interfaces.Payable;
import ExamPreparation.Implementation.YogaStudio.Classes.YogaClass;

import java.time.LocalDate;

public abstract  class Member implements Enrollable, Payable, Description {
    protected String firstName;
    protected String lastName;
    protected LocalDate joinedDate;
    protected Membership membership;
    protected double balance;

    public Member(String firstName, String lastName, Membership membership) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.joinedDate = LocalDate.now();
        this.membership = membership;
        this.balance = 0.0;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(LocalDate joinedDate) {
        this.joinedDate = joinedDate;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    @Override
    public void makePayment(double amount) {
        this.balance += amount;
    }

    @Override
    public boolean enrollFor(YogaClass yogaClass) {
        return yogaClass.addAttendee(this);
    }

    @Override
    public boolean cancel(YogaClass yogaClass) {
        return yogaClass.cancelledAttendee(this);
    }

    public abstract void attendClass(YogaClass yogaClass);
}