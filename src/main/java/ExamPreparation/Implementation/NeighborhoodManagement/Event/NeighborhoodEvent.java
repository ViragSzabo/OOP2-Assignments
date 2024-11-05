package ExamPreparation.Implementation.NeighborhoodManagement.Event;

import ExamPreparation.Implementation.NeighborhoodManagement.Resident.Resident;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NeighborhoodEvent {
    private String title;
    private EventType eventType;
    private LocalDateTime eventDate;
    private List<Resident> attendees;

    public NeighborhoodEvent(String title, EventType eventType) {
        this.title = title;
        this.eventType = eventType;
        this.eventDate = LocalDateTime.now();
        this.attendees = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    public List<Resident> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<Resident> attendees) {
        this.attendees = attendees;
    }

    public void addAttendee(Resident attendee) {
        this.attendees.add(attendee);
    }

    public void removeAttendee(Resident attendee) {
        this.attendees.remove(attendee);
    }
}