package ExamPreparation.Implementation.Remembering.Journal;

import java.io.Serializable;
import java.time.LocalDateTime;

public class MemoryEntry implements Serializable {
    private String memoryText;
    private LocalDateTime timestamp;

    public MemoryEntry(String memoryText) {
        this.memoryText = memoryText;
        this.timestamp = LocalDateTime.now();
    }

    public String getMemoryText() {
        return memoryText;
    }

    public void setMemoryText(String memoryText) {
        this.memoryText = memoryText;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}