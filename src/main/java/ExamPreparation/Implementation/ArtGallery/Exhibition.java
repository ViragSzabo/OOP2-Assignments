package ExamPreparation.Implementation.ArtGallery;

import ExamPreparation.Implementation.ArtGallery.Enums.Status;
import ExamPreparation.Implementation.ArtGallery.Exception.TooMuchArtworksToDisplayException;
import ExamPreparation.Implementation.ArtGallery.People.Artist;
import ExamPreparation.Implementation.ArtGallery.People.Buyer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Exhibition {
    private List<Artwork> availableArts;
    private HashMap<Artwork, Buyer> soldArts;
    private List<Artist> artists;

    public Exhibition() {
        this.availableArts = new ArrayList<>();
        this.soldArts = new HashMap<>();
        this.artists = new ArrayList<>();
    }

    public List<Artwork> getArts() {
        return availableArts;
    }

    public void setArts(List<Artwork> arts) {
        this.availableArts = arts;
    }

    public void addArt(Artwork art) throws TooMuchArtworksToDisplayException {
        if(!(this.availableArts.size() >= 10)) {
            art.setStatus(Status.EXHIBITED);
            this.availableArts.add(art);
        } else {
            throw new TooMuchArtworksToDisplayException();
        }
    }

    public void removeArt(Artwork art) {
        this.availableArts.remove(art);
    }

    public HashMap<Artwork, Buyer> getSoldArts() {
        return soldArts;
    }

    public void addSoldArt(Artwork art, Buyer buyer) {
        art.setStatus(Status.SOLD);
        this.soldArts.put(art, buyer);
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public void addArtist(Artist artist) {
        this.artists.add(artist);
    }

    public void removeArtist(Artist artist) {
        this.artists.remove(artist);
    }

    public void sell(Artwork art, Buyer buyer) {
        removeArt(art);
        addSoldArt(art, buyer);
        buyer.buyArt(art);
    }

    public double getTotalSales() {
        double totalPrice = 0;
        for(Artwork art: this.soldArts.keySet()) {
            totalPrice += art.getPrice();
        }
        return totalPrice;
    }
}