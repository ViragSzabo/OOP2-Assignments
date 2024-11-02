package ExamPreparation.Implementation.ComicStoreSystem.Comics;

import ExamPreparation.Implementation.ComicStoreSystem.Enums.Status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ComicSeries {
    private String title;
    private String genre;
    private List<ComicVolume> volumes;
    private Status status;

    public ComicSeries(String title, String genre) {
        this.title = title;
        this.genre = genre;
        this.volumes = new ArrayList<>();
        this.status = Status.NEEDS_ATTENTION;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<ComicVolume> getVolumes() {
        return volumes;
    }

    public void setVolumes(List<ComicVolume> volumes) {
        this.volumes = volumes;
    }

    public void addVolume(ComicVolume volume) {
        this.volumes.add(volume);
    }

    public void removeVolume(ComicVolume volume) {
        this.volumes.remove(volume);
    }

    public Status getStatus() { return status; }

    public void setStatus(Status status) { this.status = status; }

    public int getTotalPages() {
        int totalPages = 0;
        for (ComicVolume volume : volumes) {
            totalPages += volume.getNumberOfPages();
        }
        return totalPages;
    }

    public Status checkStatus() {
        for(ComicVolume volume : volumes) {
            if(volume.getNumberOfPages() > 20 && volume.getReleaseDate().isBefore(LocalDate.now())) {
                this.status = Status.STABLE;
            } else if (volume.getNumberOfPages() < 20) {
                this.status = Status.NEEDS_ATTENTION;
            } else if (volume.getReleaseDate().isAfter(LocalDate.now())) {
                this.status = Status.UNSTABLE;
            }
        }
        return status;
    }
}