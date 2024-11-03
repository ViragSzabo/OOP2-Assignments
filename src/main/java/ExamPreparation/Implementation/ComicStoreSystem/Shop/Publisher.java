package ExamPreparation.Implementation.ComicStoreSystem.Shop;

import ExamPreparation.Implementation.ComicStoreSystem.Enums.Genre;
import ExamPreparation.Implementation.ComicStoreSystem.People.Author;
import ExamPreparation.Implementation.ComicStoreSystem.Comics.ComicSeries;
import ExamPreparation.Implementation.ComicStoreSystem.Comics.ComicVolume;

import java.util.ArrayList;
import java.util.List;

public class Publisher {
    private List<Author> authors;

    public Publisher() {
        this.authors = new ArrayList<>();
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    public void removeAuthor(Author author) {
        this.authors.remove(author);
    }

    public void registerVolume(ComicVolume volume) {
        Author author = volume.getAuthor();
        ComicSeries series = author.getComics().stream()
                .filter(s -> s.getTitle().equals(volume.getTitle()))
                .findFirst()
                .orElse(new ComicSeries(volume.getTitle(), Genre.ADULT));
        series.addVolume(volume);
        author.addComic(series);
    }

    public Author findTopAuthor() {
        int max = 0;
        Author topAuthor = null;
        for(Author author : authors) {
            if(author.getTotalPages() > max) {
                max = author.getTotalPages();
                topAuthor = author;
            }
        }
        return topAuthor;
    }
}