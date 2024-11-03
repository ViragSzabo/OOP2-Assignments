package ExamPreparation.Implementation.ComicStoreSystem;

import ExamPreparation.Implementation.ComicStoreSystem.Comics.ComicSeries;
import ExamPreparation.Implementation.ComicStoreSystem.Comics.ComicVolume;
import ExamPreparation.Implementation.ComicStoreSystem.Enums.Genre;
import ExamPreparation.Implementation.ComicStoreSystem.People.Author;
import ExamPreparation.Implementation.ComicStoreSystem.Shop.Publisher;
import junit.framework.TestCase;

import java.time.LocalDate;

public class AuthorTest extends TestCase {
    private Publisher publisher;
    private Author author;
    private Author author2;
    private ComicSeries comicSeries;
    private ComicSeries comicSeries2;
    private ComicVolume volume1;
    private ComicVolume volumee;

    public void setUp() throws Exception {
        super.setUp();


        this.publisher = new Publisher();

        this.author = new Author("John", "Allison");
        this.comicSeries = new ComicSeries("Giant Days", Genre.COMEDY);
        this.volume1 = new ComicVolume(1, "Giant Days 1", 112, LocalDate.of(2015, 12, 1), author);
        this.author.addComic(comicSeries);

        this.author2 = new Author("Janet", "McAllis");
        this.comicSeries2 = new ComicSeries("Our Days", Genre.YOUNG_ADULT);
        this.author2.addComic(comicSeries2);
        this.volumee = new ComicVolume(1, "Beginnings", 250, LocalDate.of(2018, 4, 18), author2);

        this.publisher.addAuthor(author);
        this.publisher.addAuthor(author2);
        this.publisher.registerVolume(volume1);
        this.publisher.registerVolume(volumee);
    }

    public void testGetTotalPages() {
        assertEquals(112, this.author.getTotalPages());
        assertEquals(250, this.author2.getTotalPages());
    }
}