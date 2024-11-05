package ExamPreparation.Implementation.ArtGallery;

import ExamPreparation.Implementation.ArtGallery.Enums.Medium;
import ExamPreparation.Implementation.ArtGallery.Enums.Status;
import ExamPreparation.Implementation.ArtGallery.Operations.ArtworkOperations;
import ExamPreparation.Implementation.ArtGallery.People.Artist;

public class Artwork implements ArtworkOperations {
    private final String title;
    private Medium medium;
    private double size;
    private Artist artist;
    private Status status;
    private final double price;

    public Artwork(String title, Medium medium, Artist artist, double size, double price) {
        this.title = title;
        this.medium = medium;
        this.artist = artist;
        this.size = size;
        this.status = Status.AVAILABLE;
        this.price = price;
    }

    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void changeStatus(Status status) {
        this.status = status;
    }

    @Override
    public String getTitle() {
        return this.title;
    }
}