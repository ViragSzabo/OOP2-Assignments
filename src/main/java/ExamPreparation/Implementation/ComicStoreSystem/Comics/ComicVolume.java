package ExamPreparation.Implementation.ComicStoreSystem.Comics;

import ExamPreparation.Implementation.ComicStoreSystem.People.Author;
import ExamPreparation.Implementation.ComicStoreSystem.Exceptions.PublicationException;

import java.time.LocalDate;

public class ComicVolume {
    private int vNumber;
    private String title;
    private int numberOfPages;
    private LocalDate releaseDate;
    private Author author;

    public ComicVolume(int vNumber, String title, int numberOfPages, LocalDate releaseDate, Author author) {
        this.vNumber = vNumber;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.releaseDate = releaseDate;
        this.author = author;
    }

    public int getvNumber() {
        return vNumber;
    }

    public void setvNumber(int vNumber) {
        this.vNumber = vNumber;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public boolean isPublished() throws PublicationException {
        if(this.releaseDate.isAfter(LocalDate.now()))
        {
            throw new PublicationException("The published comic volume is not published yet.");
        }
        else {
            return this.releaseDate.isBefore(LocalDate.now());
        }
    }

    public void checkNumberOfPages(int numberOfPages) throws PublicationException {
        if(this.numberOfPages < 20) {
            throw new PublicationException("The number of pages is less than 20");
        }
    }
}