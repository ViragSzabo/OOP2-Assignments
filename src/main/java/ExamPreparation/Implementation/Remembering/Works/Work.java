package ExamPreparation.Implementation.Remembering.Works;

public class Work {
    private String title;
    private WorkType type;

    public Work(String title, WorkType type) {
        this.title = title;
        this.type = type;
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
}