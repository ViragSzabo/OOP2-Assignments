package ExamPreparation.Implementation.ArtGallery.Operations;

import ExamPreparation.Implementation.ArtGallery.Enums.Status;

public interface ArtworkOperations {
    double getPrice();
    void changeStatus(Status status);
    String getTitle();
}