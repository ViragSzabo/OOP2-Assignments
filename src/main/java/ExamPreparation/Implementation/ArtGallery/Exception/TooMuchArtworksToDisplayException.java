package ExamPreparation.Implementation.ArtGallery.Exception;

public class TooMuchArtworksToDisplayException extends Exception {
    public TooMuchArtworksToDisplayException() {
        super("More than 5 artworks to display is not possible!");
    }
}