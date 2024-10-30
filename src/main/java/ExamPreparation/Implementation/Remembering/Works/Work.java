package ExamPreparation.Implementation.Remembering.Works;

import java.util.ArrayList;
import java.util.List;

public class Work {
    private String title;
    private WorkType type;
    private List<Integer> ratings;

    public Work(String title, WorkType type) {
        this.title = title;
        this.type = type;
        this.ratings = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public WorkType getType() {
        return type;
    }

    public void setType(WorkType type) {
        this.type = type;
    }

    public List<Integer> getRatings() { return ratings; }

    public void setRatings(List<Integer> ratings) { this.ratings = ratings; }

    public void addRating(int rating) { this.ratings.add(rating); }

    public void removeRating(int rating) { this.ratings.remove(rating); }

    public double calculateAverageRating() {
        return ratings
                .stream()
                .mapToDouble(rating -> rating)
                .average().getAsDouble();
    }
}