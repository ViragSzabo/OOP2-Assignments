package ExamPreparation.Implementation.ComicStoreSystem;

import ExamPreparation.Implementation.ComicStoreSystem.Comics.ComicVolume;
import ExamPreparation.Implementation.ComicStoreSystem.Exceptions.PublicationException;
import ExamPreparation.Implementation.ComicStoreSystem.People.Author;
import junit.framework.TestCase;

import java.time.LocalDate;

public class ComicVolumeTest extends TestCase {
    private ComicVolume volume;
    private ComicVolume volume50;

    public void setUp() throws Exception {
        super.setUp();
        this.volume = new ComicVolume(1, "Giant Days 1", 112, LocalDate.of(2015, 12, 1), new Author("John", "Allison"));
        this.volume50 = new ComicVolume(50, "Giant Days 50", 130, LocalDate.of(2024, 8, 5), new Author("John", "Allison"));
    }

    public void testIsPublished() {
        try {
            assertTrue(this.volume.isPublished());
            assertTrue(this.volume50.isPublished());
        } catch (PublicationException e) {
            throw new RuntimeException(e);
        }
    }

    public void testCheckNumberOfPages() {
        try {
            this.volume.checkNumberOfPages(volume.getNumberOfPages());
            this.volume50.checkNumberOfPages(volume.getNumberOfPages());
        } catch (PublicationException e) {
            throw new RuntimeException(e);
        }
    }
}