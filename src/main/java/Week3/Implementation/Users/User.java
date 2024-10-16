package Week3.Implementation.Users;

import Week2.Implementation.Hospital_Part2.CodeBlackException;
import Week3.Implementation.Conditions.Validation;

import java.time.Period;
import java.time.LocalDate;

public class User {
    private String name;
    private String email;
    private LocalDate birthDate;

    public User(String name, String email, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}