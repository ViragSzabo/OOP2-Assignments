package ExamPreparation.Implementation.Remembering.System;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

    private void saveTributes(List<String> tributes, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (String tribute : tributes) {
                writer.write(tribute + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving tributes: " + e.getMessage());
        }
    }

    private void loadTributes(List<String> tributes, String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                tributes.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error loading tributes: " + e.getMessage());
        }
    }

    public void displayMultimediaLinks() {
        System.out.println("Multimedia links for tribute: " + text);
        for(String link : multimediaLinks) {
            System.out.println(link);
        }
    }
}