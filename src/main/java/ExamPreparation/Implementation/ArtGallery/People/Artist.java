package ExamPreparation.Implementation.ArtGallery.People;

import ExamPreparation.Implementation.ArtGallery.Enums.Gender;

import java.time.LocalDate;
import java.time.Period;

public class Artist extends Person {
    public Artist(String firstName, String lastName, String email, Gender gender, LocalDate birthDate) {
        super(firstName, lastName, email, gender, birthDate);
    }

    @Override
    public String getDescription() { return "Artist: " + getFullName(); }
}