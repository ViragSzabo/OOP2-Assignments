package ExamPreparation.Implementation.ArtGallery;

import ExamPreparation.Implementation.ArtGallery.Enums.Medium;
import ExamPreparation.Implementation.ArtGallery.Enums.Status;

public class Artwork {
    private String title;
    private Medium medium;
    private double size;
    private Artist artist;
    private Status status;
    private double price;

    public Artwork(String title, Medium medium, Artist artist, double size, double price) {
        this.title = title;
        this.medium = medium;
        this.artist = artist;
        this.size = size;
        this.status = Status.AVAILABLE;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}