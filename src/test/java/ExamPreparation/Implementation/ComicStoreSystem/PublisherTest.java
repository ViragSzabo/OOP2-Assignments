package ExamPreparation.Implementation.ComicStoreSystem;

import ExamPreparation.Implementation.ComicStoreSystem.Comics.ComicSeries;
import ExamPreparation.Implementation.ComicStoreSystem.Comics.ComicVolume;
import ExamPreparation.Implementation.ComicStoreSystem.Enums.Genre;
import ExamPreparation.Implementation.ComicStoreSystem.People.Author;
import ExamPreparation.Implementation.ComicStoreSystem.Shop.Publisher;
import junit.framework.TestCase;

import java.time.LocalDate;

public class PublisherTest extends TestCase {
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

        this.author2 = new Author("Janet", "McAllis");
        this.comicSeries2 = new ComicSeries("Our Days", Genre.YOUNG_ADULT);
        this.volumee = new ComicVolume(1, "Beginnings", 250, LocalDate.of(2018, 4, 18), author2);

        this.publisher.addAuthor(author);
        this.publisher.addAuthor(author2);
        this.publisher.registerVolume(volume1);
        this.publisher.registerVolume(volumee);
    }

    public void testRegisterVolume() {
        assertEquals(1, publisher.getAuthors().get(0).getComics().size());
    }

    public void testFindTopAuthor() {
        // Ensure the setup is correct
        assertEquals(2, this.publisher.getAuthors().size());

        // Verify that each author has the correct total pages
        int totalPagesAuthor1 = author.getTotalPages();
        int totalPagesAuthor2 = author2.getTotalPages();
        System.out.println("Total pages for " + author.getFirstName() + ": " + totalPagesAuthor1);
        System.out.println("Total pages for " + author2.getFirstName() + ": " + totalPagesAuthor2);

        // Find and check the top author
        Author topAuthor = this.publisher.findTopAuthor();
        assertEquals(author2, topAuthor);
    }
}