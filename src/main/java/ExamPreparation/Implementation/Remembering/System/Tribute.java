package ExamPreparation.Implementation.Remembering.System;

import java.util.ArrayList;
import java.util.List;

public class Tribute {
    private String text;
    private int likes;
    private List<String> multimediaLinks;

    public Tribute(String text) {
        this.text = text;
        this.likes = 0;
        this.multimediaLinks = new ArrayList<>();
    }

    public String getText() { return text; }

    public void setText(String text) { this.text = text; }

    public int getLikes() { return likes; }

    public void setLikes(int likes) { this.likes = likes; }

    public List<String> getMultimediaLinks() { return multimediaLinks; }

    public void setMultimediaLinks(List<String> multimediaLinks) { this.multimediaLinks = multimediaLinks; }

    public void addMultimediaLink(String link) { this.multimediaLinks.add(link); }

    public void removeMultimediaLink(String link) { this.multimediaLinks.remove(link); }

    public void like() { this.likes++; }

    public void displayMultimediaLinks() {
        System.out.println("Multimedia links for tribute: " + text);
        for(String link : multimediaLinks) {
            System.out.println(link);
        }
    }
}