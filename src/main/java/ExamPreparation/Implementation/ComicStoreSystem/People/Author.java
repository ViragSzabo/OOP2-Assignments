package ExamPreparation.Implementation.ComicStoreSystem.People;

import ExamPreparation.Implementation.ComicStoreSystem.Comics.ComicSeries;

import java.util.ArrayList;
import java.util.List;

public class Author {
    private String firstName;
    private String lastName;
    private int experienceLevel;
    private List<ComicSeries> comics;

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.experienceLevel = 0;
        this.comics = new ArrayList<ComicSeries>();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(int experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public List<ComicSeries> getComics() {
        return comics;
    }

    public void setComics(List<ComicSeries> comics) {
        this.comics = comics;
    }

    public void addComic(ComicSeries comic) {
        comics.add(comic);
    }

    public void removeComic(ComicSeries comic) {
        comics.remove(comic);
    }

    public int getTotalPages() {
        int authorTotalWrittenPages = 0;
        for(ComicSeries comic : comics) {
            int pages = comic.getTotalPages();
            authorTotalWrittenPages += pages;
        }
        return authorTotalWrittenPages;
    }
}