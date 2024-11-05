package ExamPreparation.Implementation.NeighborhoodManagement.Resident;

import ExamPreparation.Implementation.NeighborhoodManagement.Event.NeighborhoodEvent;

public interface Person {
    String getFullName();
    void attendEvent(NeighborhoodEvent event);
}