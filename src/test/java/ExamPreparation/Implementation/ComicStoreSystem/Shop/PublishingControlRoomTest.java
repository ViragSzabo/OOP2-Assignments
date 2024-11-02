package ExamPreparation.Implementation.ComicStoreSystem.Shop;

import ExamPreparation.Implementation.ComicStoreSystem.Comics.ComicSeries;
import ExamPreparation.Implementation.ComicStoreSystem.Comics.ComicVolume;
import ExamPreparation.Implementation.ComicStoreSystem.People.Author;
import junit.framework.TestCase;

import java.time.LocalDate;

public class PublishingControlRoomTest extends TestCase {
    private Publisher publisher;
    private PublishingControlRoom control;
    private Author author;
    private Author author2;
    private ComicSeries comicSeries;
    private ComicSeries comicSeries2;
    private ComicVolume volume1;
    private ComicVolume volumee;

    public void setUp() throws Exception {
        super.setUp();

        this.publisher = new Publisher();
        this.control = new PublishingControlRoom(publisher);

        this.author = new Author("John", "Allison");
        this.comicSeries = new ComicSeries("Giant Days", "comedy");
        this.volume1 = new ComicVolume(1, "Giant Days 1", 112, LocalDate.of(2015, 12, 1), author);

        this.author2 = new Author("Janet", "McAllis");
        this.comicSeries2 = new ComicSeries("Our Days", "fiction");
        this.volumee = new ComicVolume(1, "Beginnings", 19, LocalDate.of(2018, 4, 18), author2);

        this.publisher.addAuthor(author);
        this.publisher.addAuthor(author2);
        this.publisher.registerVolume(volume1);
        this.publisher.registerVolume(volumee);
    }

    public void testIsPublishingStable() {
        assertTrue(this.control.isPublishingStable(author));
        assertFalse(this.control.isPublishingStable(author2));
    }
}