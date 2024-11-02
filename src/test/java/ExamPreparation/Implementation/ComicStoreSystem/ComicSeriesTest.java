package ExamPreparation.Implementation.ComicStoreSystem;

import ExamPreparation.Implementation.ComicStoreSystem.Comics.ComicSeries;
import ExamPreparation.Implementation.ComicStoreSystem.Comics.ComicVolume;
import ExamPreparation.Implementation.ComicStoreSystem.People.Author;
import junit.framework.TestCase;

import java.time.LocalDate;

public class ComicSeriesTest extends TestCase {
    private Author author;
    private ComicSeries comicSeries;

    public void setUp() throws Exception {
        super.setUp();

        this.author = new Author("John", "Allison");
        this.comicSeries = new ComicSeries("Giant Days", "comedy");
        this.author.addComic(comicSeries);
        this.comicSeries.addVolume(new ComicVolume(1, "Giant Days 1", 112, LocalDate.of(2015, 12, 1), author));
    }

    public void testGetTotalPages() {
        assertEquals(112, comicSeries.getTotalPages());
    }
}