package ExamPreparation.Implementation.ArtGallery;

import ExamPreparation.Implementation.ArtGallery.Enums.Gender;
import ExamPreparation.Implementation.ArtGallery.Enums.Medium;
import ExamPreparation.Implementation.ArtGallery.Enums.Status;
import ExamPreparation.Implementation.ArtGallery.Exception.TooMuchArtworksToDisplayException;
import ExamPreparation.Implementation.ArtGallery.People.Artist;
import ExamPreparation.Implementation.ArtGallery.People.Buyer;
import junit.framework.TestCase;

import java.time.LocalDate;

public class ExhibitionTest extends TestCase {
    Exhibition modernArtExhibition;
    Artwork starryNight;
    Artwork theThinker;
    Artwork girlWithPearl;
    Artwork selfPortrait;
    Artwork persistenceOfMemory;
    Artwork waterLilies;
    Artist vincent;
    Artist auguste;
    Artist frida;
    Artist johannes;
    Artist salvador;
    Artist claude;
    Buyer johnDoe;
    Buyer emilyStone;
    Buyer alexMorgan;

    public void setUp() throws Exception {
        super.setUp();
        modernArtExhibition = new Exhibition();

        vincent = new Artist("Vincent", "van Gogh","vincent.vangogh@gmail.com",
                Gender.MAN, LocalDate.of(1853, 3, 30));
        auguste = new Artist("Auguste", "Rodin","auguste.rodin@gmail.com",
                Gender.MAN, LocalDate.of(1840, 11, 12));
        frida = new Artist("Frida", "Kahlo", "frida.kahlo@gmail.com",
                Gender.WOMAN, LocalDate.of(1907, 7, 6));
        johannes = new Artist("Johannes", "Vermeer",  "johannes.vermeer@gmail.com",
                Gender.MAN, LocalDate.of(1632, 10, 31));
        salvador = new Artist("Salvador", "Dalí","salvador.dali@gmail.com",
                Gender.MAN, LocalDate.of(1904, 5, 11));
        claude = new Artist("Claude", "Monet","claude.monet@gmail.com",
                Gender.MAN, LocalDate.of(1840, 11, 14));

        johnDoe = new Buyer("John", "Doe",
                "john.doe@example.com", Gender.MAN,
                LocalDate.of(1985, 5, 15));
        emilyStone = new Buyer("Emily", "Stone",
                "emily.stone@example.com", Gender.WOMAN,
                LocalDate.of(1990, 12, 10));
        alexMorgan = new Buyer("Alex", "Morgan",
                "alex.morgan@example.com", Gender.NON_BINARY,
                LocalDate.of(1995, 7, 21));

        starryNight = new Artwork("Starry Night", Medium.OIL,
                vincent, 92 * 73, 1200000.00);
        theThinker = new Artwork("The Thinker", Medium.SCULPTURE,
                auguste, 186, 2500000.00);
        girlWithPearl = new Artwork("Girl with a Pearl Earring", Medium.OIL,
                johannes, 44.5 * 39, 3000000.00);
        selfPortrait = new Artwork("Self-Portrait with Thorn Necklace and Hummingbird", Medium.OIL,
                frida, 61 * 47, 500000.00);
        persistenceOfMemory = new Artwork("The Persistence of Memory", Medium.OIL,
                salvador, 24 * 33, 1300000.00);
        waterLilies = new Artwork("Water Lilies", Medium.OIL,
                claude, 200 * 180, 3000000.00);

        modernArtExhibition.getArtists().add(vincent);
        modernArtExhibition.getArtists().add(auguste);
        modernArtExhibition.getArtists().add(frida);
        modernArtExhibition.getArtists().add(johannes);
        modernArtExhibition.getArtists().add(salvador);
        modernArtExhibition.getArtists().add(claude);
    }

    public void testAddArt() {
        try {
            modernArtExhibition.addArt(starryNight);
            modernArtExhibition.addArt(theThinker);
            modernArtExhibition.addArt(girlWithPearl);
            modernArtExhibition.addArt(selfPortrait);
            modernArtExhibition.addArt(persistenceOfMemory);
            modernArtExhibition.addArt(waterLilies);
        } catch (TooMuchArtworksToDisplayException e) {
            throw new RuntimeException(e);
        }
        assertEquals(6, modernArtExhibition.getArts().size());
    }

    public void testSell() {
        try {
            modernArtExhibition.addArt(starryNight);
            modernArtExhibition.addArt(theThinker);
            modernArtExhibition.addArt(girlWithPearl);
        } catch (TooMuchArtworksToDisplayException e) {
            throw new RuntimeException(e);
        }

        modernArtExhibition.sell(starryNight, johnDoe);
        assertEquals(Status.SOLD, starryNight.getStatus());
        assertTrue(modernArtExhibition.getSoldArts().containsKey(starryNight));
    }

    public void testGetTotalSales() {
        try {
            modernArtExhibition.addArt(starryNight);
            modernArtExhibition.addArt(theThinker);
            modernArtExhibition.addArt(girlWithPearl);
        } catch (TooMuchArtworksToDisplayException e) {
            throw new RuntimeException(e);
        }

        modernArtExhibition.sell(starryNight, johnDoe);
        modernArtExhibition.sell(theThinker, emilyStone);
        modernArtExhibition.sell(girlWithPearl, alexMorgan);
        assertEquals(6700000.00, modernArtExhibition.getTotalSales());
    }
}