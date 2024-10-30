package ExamPreparation.Implementation.Remembering.Journal;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MemoryJournal {
    private List<MemoryEntry> entries;

    public MemoryJournal() {
        this.entries = new ArrayList<MemoryEntry>();
    }

    public void addMemoryEntry(MemoryEntry entry) {
        this.entries.add(entry);
    }

    public List<MemoryEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<MemoryEntry> entries) {
        this.entries = entries;
    }

    public void saveMemoryJournal(MemoryJournal journal, String filename) {
        try(ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(filename)))) {
            oos.writeObject(journal);
        } catch (Exception e) {
            System.out.println("Error saving journal: " + e.getMessage());
        }
    }

    public MemoryJournal loadMemoryJournal(String filename) {
        try(ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(filename)))) {
            return (MemoryJournal) ois.readObject();
        } catch (Exception e) {
            System.out.println("Error loading journal: " + e.getMessage());
            return null;
        }
    }

    public void displayJournal() {
        System.out.println("Memory Journal");
        for (MemoryEntry entry : entries) {
            System.out.println(
                    entry.getTimestamp() +
                    ": " +
                    entry.getMemoryText()
            );
        }
    }
}