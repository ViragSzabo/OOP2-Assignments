package ExamPreparation.Implementation.ArtGallery;

import ExamPreparation.Implementation.ArtGallery.Enums.Gender;
import ExamPreparation.Implementation.ArtGallery.Enums.Medium;
import junit.framework.TestCase;

import java.time.LocalDate;

public class BuyerTest extends TestCase {
    Exhibition modernArtExhibition;
    Artwork starryNight;
    Artwork theThinker;
    Artwork girlWithPearl;
    Artist vincent;
    Artist auguste;
    Artist frida;
    Buyer johnDoe;
    Buyer emilyStone;
    Buyer alexMorgan;

    public void setUp() throws Exception {
        super.setUp();
        modernArtExhibition = new Exhibition();
        starryNight = new Artwork("Starry Night", Medium.OIL,
                new Artist("Vincent", "van Gogh",
                        LocalDate.of(1853, 3, 30), Gender.MAN),
                92 * 73, 1200000.00);
        theThinker = new Artwork("The Thinker", Medium.SCULPTURE,
                new Artist("Auguste", "Rodin",
                        LocalDate.of(1840, 11, 12), Gender.MAN),
                186, 2500000.00);
        girlWithPearl = new Artwork("Girl with a Pearl Earring", Medium.OIL,
                new Artist("Johannes", "Vermeer",
                        LocalDate.of(1632, 10, 31), Gender.MAN),
                44.5 * 39, 3000000.00);
        vincent = new Artist("Vincent", "van Gogh",
                LocalDate.of(1853, 3, 30), Gender.MAN);
        auguste = new Artist("Auguste", "Rodin",
                LocalDate.of(1840, 11, 12), Gender.MAN);
        frida = new Artist("Frida", "Kahlo",
                LocalDate.of(1907, 7, 6), Gender.WOMAN);
        johnDoe = new Buyer("John", "Doe",
                "john.doe@example.com", Gender.MAN,
                LocalDate.of(1985, 5, 15));

        modernArtExhibition.addArt(starryNight);
        modernArtExhibition.addArt(theThinker);
        modernArtExhibition.addArt(girlWithPearl);
        modernArtExhibition.getArtists().add(vincent);
        modernArtExhibition.getArtists().add(auguste);
        modernArtExhibition.getArtists().add(frida);
    }

    public void testBuyArt() {
        johnDoe.buyArt(starryNight);
        johnDoe.buyArt(theThinker);
        johnDoe.buyArt(girlWithPearl);
        assertEquals(3, johnDoe.getOwnedArts().size());
    }
}